-- -------------------------------------------------------------------------------------------------
-- Database Name: mosip_pms
-- Table Name 	: pms.tspid_seq
-- Purpose    	: Trusted Service Provider ID Sequence : Maintains latest sequence number available for TSP ID  generation.
--           
-- Create By   	: Sadanandegowda DM
-- Created Date	: 30-Apr-2020
-- 
-- Modified Date        Modified By         Comments / Remarks
-- ------------------------------------------------------------------------------------------
-- Aug-2020             Sadanndegowda       Updated Schema name 
-- ------------------------------------------------------------------------------------------

-- object: pms.tspid_seq | type: TABLE --
-- DROP TABLE IF EXISTS pms.tspid_seq CASCADE;
CREATE TABLE pms.tspid_seq(
	curr_seq_no integer NOT NULL,
	cr_by character varying(256) NOT NULL,
	cr_dtimes timestamp NOT NULL,
	upd_by character varying(256),
	upd_dtimes timestamp,
	CONSTRAINT pk_tspidseq_id PRIMARY KEY (curr_seq_no)

);
-- ddl-end --
COMMENT ON TABLE pms.tspid_seq IS 'Trusted Service Provider ID Sequence : Maintains latest sequence number available for TSP ID  generation';
-- ddl-end --
COMMENT ON COLUMN pms.tspid_seq.curr_seq_no IS 'Current Sequence Number : Latest sequence number available for TSP (Trusted Service Provider) ID generation';
-- ddl-end --
COMMENT ON COLUMN pms.tspid_seq.cr_by IS 'Created By : ID or name of the user who create / insert record';
-- ddl-end --
COMMENT ON COLUMN pms.tspid_seq.cr_dtimes IS 'Created DateTimestamp : Date and Timestamp when the record is created/inserted';
-- ddl-end --
COMMENT ON COLUMN pms.tspid_seq.upd_by IS 'Updated By : ID or name of the user who update the record with new values';
-- ddl-end --
COMMENT ON COLUMN pms.tspid_seq.upd_dtimes IS 'Updated DateTimestamp : Date and Timestamp when any of the fields in the record is updated with new values.';
-- ddl-end --