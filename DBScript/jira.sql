create schema bugtracking

create bugtracking.user_table(
	user_id_pk SERIAL primary key,
	user_name varchar(15),
	first_name varchar(20),
	last_name varchar(20),
	password varchar(20),
	role_id_fk int,
	user_mail_id varchar(30),
	
	foreign key(role_id_fk) references bugtracking.role_name(role_id)
	
	

);

create table bugtracking.project_details(
	project_id_pk serial primary key,
	project_name varchar(30),
	project_description varchar(500), 
	project_added_by int,
	project_team_lead int,
	project_created_date date,
	project_final_date date,
	project_status varchar(1),
	project_delay_comments varchar(500),
	
	foreign key(project_added_by)  references  bugtracking.user_table(user_id_pk),
	foreign key(project_team_lead)  references  bugtracking.user_table(user_id_pk)
);

create table bugtracking.bug_issues(
	bug_id_pk serial  PRIMARY key,
	bug_name varchar(30),
	bug_description varchar(500),
	bug_image blob,
	user_id_fk int ,
	bug_status varchar(1),
	bug_created_date date,
	bug_fixed_date date,
	project_name_fk_id int,

	foreign key(user_id_fk) references bugtracking.user_table(user_id_pk),
	foreign key(project_name_fk_id) references bugtracking.project_name(project_id_pk)
);


create table bugtracking.role_name(
	role_id serial primary key,
	role_name varchar(20)
);




