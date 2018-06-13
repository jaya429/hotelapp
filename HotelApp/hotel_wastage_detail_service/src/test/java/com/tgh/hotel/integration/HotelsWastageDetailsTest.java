package com.tgh.hotel.integration;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.thg.hotel.HotelWastageDetailsServiceApplication;
import com.thg.hotel.enums.WastageType;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotelWastageDetailsServiceApplication.class)
@DirtiesContext
@SqlGroup({@Sql(scripts = {"/sqls/hotelsWastageDetails.sql"}),
    @Sql(scripts = {"/sqls/teardown.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class HotelsWastageDetailsTest {

  private MockMvc               mockMvc;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
  }

  @Test
  public void testGetHotelWastageDetailsById() throws Exception {
    mockMvc.perform(get("/hotels/wastagedetails/{hotelid}/{wastage_type}/{date}", 1, WastageType.FOOD, "2018-01-01"))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id.hotelId").value(1))
        .andExpect(jsonPath("$.id.wastageType").value("FOOD"))
        .andExpect(jsonPath("$.id.date").value("2018-01-01T00:00:00.000+0000"))
        .andExpect(jsonPath("$.hotelWastageAttributes").value("KGS"))
        .andExpect(jsonPath("$.units").value(1000));
  }

  @Test
  public void testGetHotelWastageDetailsByHotels() throws Exception {
    mockMvc.perform(get("/hotels/wastagedetails/search")
        .param("hotelid", "1")
        .param("wastageType", "FOOD"))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
  }
}
