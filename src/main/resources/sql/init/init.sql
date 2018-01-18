drop table if exists prefs;
drop table if exists request; 
drop table if exists requesttype; 
drop table if exists clients; 

create table clients (
  idx serial,
  description text,
  isactive boolean NOT NULL DEFAULT true,
  ismoderated  boolean NOT NULL DEFAULT true,
  phone text,
  email text,
  address text,
  latitude double precision,
  longitude double precision,
  CONSTRAINT clients_pkey PRIMARY KEY (idx)
  );

create table requesttype (
  idx serial,
  description text,
  CONSTRAINT requesttype_pkey PRIMARY KEY (idx)
  );
  
create table request (
  idx serial,
  description text,
  requesttypeid int,
  clientid int,
  datecreate timestamp without time zone,
  datetarget timestamp without time zone,
  datefinish timestamp without time zone,
  comment text,
  vendorid int,
  CONSTRAINT request_pkey PRIMARY KEY (idx)
  );
  
create table prefs (
  idx serial,
  name text,
  "value" text,
  CONSTRAINT prefs_pkey PRIMARY KEY (idx)
  );
  
insert into prefs (name, "value") values ('company_name', 'ООО Тестовая компания');
insert into prefs (name, "value") values ('api_version', '0.1');

