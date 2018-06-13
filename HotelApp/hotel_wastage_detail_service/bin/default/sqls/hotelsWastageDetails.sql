CREATE TABLE IF NOT EXISTS tgh_htl_wstg_dtl (
	htl_wstg_by_mnth date not null, 
	htl_id integer not null, 
	htl_wstg_type varchar(255) not null, 
	htl_wstg_attr integer, 
	htl_wstg_unts integer, 
	primary key (htl_wstg_by_mnth, htl_id, htl_wstg_type)
);


INSERT INTO tgh_htl_wstg_dtl(	htl_wstg_by_mnth, htl_id, htl_wstg_type, htl_wstg_attr, htl_wstg_unts) VALUES (TO_DATE('2018-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1, 2, 0, 1000);
INSERT INTO tgh_htl_wstg_dtl(	htl_wstg_by_mnth, htl_id, htl_wstg_type, htl_wstg_attr, htl_wstg_unts) VALUES (TO_DATE('2018-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1, 0, 2, 1000);
INSERT INTO tgh_htl_wstg_dtl(	htl_wstg_by_mnth, htl_id, htl_wstg_type, htl_wstg_attr, htl_wstg_unts) VALUES (TO_DATE('2018-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 3, 1, 1, 10000);