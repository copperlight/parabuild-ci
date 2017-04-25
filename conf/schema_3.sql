create cached table USERS (
  ID integer not null identity,
  NAME varchar(100) not null,
  FNAME varchar(100) not null,
  EMAIL varchar(100) not null,
  PASSWORD varchar(100) not null,
  IS_ADMIN varchar(3) not null,
  ROLES varchar(254) not null,
  ENABLED char(1) not null,
  IM_TYPE tinyint not null,
  IM_ADDRESS varchar(100) not null,
  TIMESTAMP bigint not null,
  constraint USERS_UC1 unique (ID)
);
create unique index USERS_PK on USERS(ID);
create unique index USERS_AK1 on USERS(NAME);


create cached table USER_ATTRIBUTE (
  USER_ID integer not null,
  ID integer not null identity,
  NAME varchar(80) not null,
  VALUE varchar(1024),
  TIMESTAMP bigint not null,
  constraint USER_ATTRIBUTE_UC1 unique (ID),
  constraint USER_ATTRIBUTE_FC1 foreign key (USER_ID) references USERS(ID) ON DELETE CASCADE
);
create unique index USER_ATTRIBUTE_PK on USER_ATTRIBUTE(ID);
create unique index USER_ATTRIBUTE_AK1 on USER_ATTRIBUTE(USER_ID, NAME);
create index USER_ATTRIBUTE_FK1 on USER_ATTRIBUTE(USER_ID);


create cached table GROUPS (
  ID integer not null identity,
  NAME varchar(254) not null,
  DESCR varchar(254) not null,
  ENABLED char(1) not null,
  TIMESTAMP bigint not null,
  constraint GROUPS_UC1 unique (ID)
);
create unique index GROUPS_PK on GROUPS(ID);
create unique index GROUPS_AK1 on GROUPS(NAME);


create cached table GROUP_ATTRIBUTE (
  GROUP_ID integer not null,
  ID integer not null identity,
  NAME varchar(80) not null,
  VALUE varchar(1024),
  TIMESTAMP bigint not null,
  constraint GROUP_ATTRIBUTE_UC1 unique (ID),
  constraint GROUP_ATTRIBUTE_FC1 foreign key (GROUP_ID) references GROUPS(ID) ON DELETE CASCADE
);
create unique index GROUP_ATTRIBUTE_PK on GROUP_ATTRIBUTE(ID);
create unique index GROUP_ATTRIBUTE_AK1 on GROUP_ATTRIBUTE(GROUP_ID, NAME);
create index GROUP_ATTRIBUTE_FK1 on GROUP_ATTRIBUTE(GROUP_ID);


create cached table USER_GROUP (
  ID integer not null identity,
  USER_ID integer not null,
  GROUP_ID integer not null,
  constraint USER_GROUP_UC1 unique (ID),
  constraint USER_GROUP_FC1 foreign key (USER_ID) references USERS(ID) ON DELETE CASCADE,
  constraint USER_GROUP_FC2 foreign key (GROUP_ID) references GROUPS(ID) ON DELETE CASCADE
);
create unique index USER_GROUP_PK on USER_GROUP(ID);
create unique index USER_GROUP_AK1 on USER_GROUP(USER_ID, GROUP_ID);
create index USER_GROUP_FK1 on USER_GROUP(GROUP_ID);
create index USER_GROUP_FK2 on USER_GROUP(USER_ID);


create cached table SYSTEM_PROPERTY (
  ID integer not null identity,
  NAME varchar(80) not null,
  VALUE varchar(2048),
  TIMESTAMP bigint not null,
  constraint SYSTEM_PROPERTY_UC1 unique (ID)
);
create unique index SYSTEM_PROPERTY_PK on SYSTEM_PROPERTY(ID);
create unique index SYSTEM_PROPERTY_AK1 on SYSTEM_PROPERTY(NAME);


create cached table BUILD_CONFIG (
  ID integer not null identity,
  NAME varchar(30) not null,
  RUNNER tinyint not null,
  SCHEDULE tinyint not null,
  SCM tinyint not null,
  ACCESS tinyint not null,
  STARTUP_STATUS integer not null,
  EMAIL_DOMAIN varchar(80) not null,
  SCM_EMAIL varchar(3) not null,
  BUILDER_HOST varchar(80) not null,
  BUILDER_PASSWORD varchar(80) not null,
  DELETED char(1) not null,
  SUBORDINATE char(1) not null,
  TIMESTAMP bigint not null,
  constraint BUILD_CONFIG_UC1 unique (ID)
);
create unique index BUILD_CONFIG_PK on BUILD_CONFIG(ID);
create index BUILD_CONFIG_IX1 on BUILD_CONFIG(NAME, DELETED);


create cached table BUILD_CONFIG_ATTRIBUTE (
  BUILD_CONFIG_ID integer not null,
  ID integer not null identity,
  NAME varchar(80) not null,
  VALUE varchar(1024),
  TIMESTAMP bigint not null,
  constraint BUILD_CONFIG_ATTRIBUTE_UC1 unique (ID),
  constraint BUILD_CONFIG_ATTRIBUTE_FC1 foreign key (BUILD_CONFIG_ID) references BUILD_CONFIG(ID) ON DELETE CASCADE
);
create unique index BUILD_CONFIG_ATTRIBUTE_PK on BUILD_CONFIG_ATTRIBUTE(ID);
create unique index BUILD_CONFIG_ATTRIBUTE_AK1 on BUILD_CONFIG_ATTRIBUTE(BUILD_CONFIG_ID, NAME);
create index BUILD_CONFIG_ATTRIBUTE_FK1 on BUILD_CONFIG_ATTRIBUTE(BUILD_CONFIG_ID);


create cached table BUILD_ACCESS (
  ID integer not null identity,
  GROUP_ID integer not null,
  BUILD_ID integer not null,
  TIMESTAMP bigint not null,
  constraint BUILD_ACCESS_UC1 unique (ID),
  constraint BUILD_ACCESS_FC1 foreign key (BUILD_ID) references BUILD_CONFIG(ID) ON DELETE CASCADE,
  constraint BUILD_ACCESS_FC2 foreign key (GROUP_ID) references GROUPS(ID) ON DELETE CASCADE
);
create unique index BUILD_ACCESS_PK on BUILD_ACCESS(ID);
create unique index BUILD_ACCESS_AK1 on BUILD_ACCESS(BUILD_ID, GROUP_ID);
create index BUILD_ACCESS_FK1 on BUILD_ACCESS(GROUP_ID);
create index BUILD_ACCESS_FK2 on BUILD_ACCESS(BUILD_ID);


create cached table SUBORDINATE (
  ID integer not null identity,
  LEAD_ID integer not null,
  MANAGED_ID integer not null,
  constraint SUBORDINATE_UC1 unique (ID),
  constraint SUBORDINATE_FC1 foreign key (LEAD_ID) references BUILD_CONFIG(ID) ON DELETE CASCADE,
  constraint SUBORDINATE_FC2 foreign key (MANAGED_ID) references BUILD_CONFIG(ID) ON DELETE CASCADE
);
create unique index SUBORDINATE_PK on SUBORDINATE(ID);
create unique index SUBORDINATE_FK1 on SUBORDINATE(MANAGED_ID);
create index SUBORDINATE_FK2 on SUBORDINATE(LEAD_ID);


create cached table SUBORDINATE_ATTRIBUTE (
  SUBORDINATE_ID integer not null,
  ID integer not null identity,
  NAME varchar(80) not null,
  VALUE varchar(1024),
  TIMESTAMP bigint not null,
  constraint SUBORDINATE_ATTRIBUTE_UC1 unique (ID),
  constraint SUBORDINATE_ATTRIBUTE_FC1 foreign key (SUBORDINATE_ID) references SUBORDINATE(ID) ON DELETE CASCADE
);
create unique index SUBORDINATE_ATTRIBUTE_PK on SUBORDINATE_ATTRIBUTE(ID);
create unique index SUBORDINATE_ATTRIBUTE_AK1 on SUBORDINATE_ATTRIBUTE(SUBORDINATE_ID, NAME);
create index SUBORDINATE_ATTRIBUTE_FK1 on SUBORDINATE_ATTRIBUTE(SUBORDINATE_ID);


create cached table SOURCE_CONTROL_PROPERTY (
  BUILD_ID integer not null,
  ID integer not null identity,
  NAME varchar(80) not null,
  TIMESTAMP bigint not null,
  VALUE varchar(1024),
  constraint SOURCE_CONTROL_PROPERTY_UC1 unique (ID),
  constraint SOURCE_CONTROL_PROPERTY_FC1 foreign key (BUILD_ID) references BUILD_CONFIG(ID) ON DELETE CASCADE
);
create unique index SOURCE_CONTROL_PROPERTY_PK on SOURCE_CONTROL_PROPERTY(ID);
create unique index SOURCE_CONTROL_PROPERTY_AK1 on SOURCE_CONTROL_PROPERTY(BUILD_ID,NAME);
create index SOURCE_CONTROL_PROPERTY_FK1 on SOURCE_CONTROL_PROPERTY(BUILD_ID);


create cached table SCM_PATH (
  BUILD_ID integer not null,
  ID integer not null identity,
  PATH varchar(1024) not null,
  TIMESTAMP bigint not null,
  constraint SCM_PATH_UC1 unique (ID),
  constraint SCM_PATH_FC1 foreign key (BUILD_ID) references BUILD_CONFIG(ID) ON DELETE CASCADE
);
create unique index SCM_PATH_PK on SCM_PATH(ID);
create index SCM_PATH_FK1 on SCM_PATH(BUILD_ID);


create cached table SCHEDULE_PROPERTY (
  BUILD_ID integer not null,
  ID integer not null identity,
  NAME varchar(80) not null,
  VALUE varchar(1024),
  TIMESTAMP bigint not null,
  constraint SCHEDULE_PROPERTY_UC1 unique (ID),
  constraint SCHEDULE_PROPERTY_FC1 foreign key (BUILD_ID) references BUILD_CONFIG(ID) ON DELETE CASCADE
);
create unique index SCHEDULE_PROPERTY_PK on SCHEDULE_PROPERTY(ID);
create unique index SCHEDULE_PROPERTY_AK1 on SCHEDULE_PROPERTY(BUILD_ID, NAME);
create index SCHEDULE_PROPERTY_FK1 on SCHEDULE_PROPERTY(BUILD_ID);


create cached table BUILD_ATTRIBUTE (
  BUILD_ID integer not null,
  ID integer not null identity,
  NAME varchar(80) not null,
  VALUE varchar(1024),
  TIMESTAMP bigint not null,
  constraint BUILD_ATTRIBUTE_UC1 unique (ID),
  constraint BUILD_ATTRIBUTE_FC1 foreign key (BUILD_ID) references BUILD_CONFIG(ID) ON DELETE CASCADE
);
create unique index BUILD_ATTRIBUTE_PK on BUILD_ATTRIBUTE(ID);
create unique index BUILD_ATTRIBUTE_AK1 on BUILD_ATTRIBUTE(BUILD_ID, NAME);
create index BUILD_ATTRIBUTE_FK1 on BUILD_ATTRIBUTE(BUILD_ID);


create cached table LABEL_PROPERTY (
  BUILD_ID integer not null,
  ID integer not null identity,
  NAME varchar(80) not null,
  VALUE varchar(1024),
  TIMESTAMP bigint not null,
  constraint LABEL_PROPERTY_UC1 unique (ID),
  constraint LABEL_PROPERTY_FC1 foreign key (BUILD_ID) references BUILD_CONFIG(ID) ON DELETE CASCADE
);
create unique index LABEL_PROPERTY_PK on LABEL_PROPERTY(ID);
create unique index LABEL_PROPERTY_AK1 on LABEL_PROPERTY(BUILD_ID, NAME);
create index LABEL_PROPERTY_FK1 on LABEL_PROPERTY(BUILD_ID);


create cached table LOG_CONFIG (
  ID integer not null identity,
  BUILD_ID integer not null,
  DESCRIPTION varchar(80) not null,
  PATH varchar(1024) not null,
  TYPE tinyint not null,
  TIMESTAMP bigint not null,
  constraint LOG_CONFIG_UC1 unique (ID),
  constraint LOG_CONFIG_FC1 foreign key (BUILD_ID) references BUILD_CONFIG(ID) ON DELETE CASCADE
);

create unique index LOG_CONFIG_PK on LOG_CONFIG(ID);
create index LOG_CONFIG_FK1 on LOG_CONFIG(BUILD_ID);


create cached table LOG_CONFIG_PROPERTY (
  ID integer not null identity,
  LOG_CONFIG_ID integer not null,
  NAME varchar(80) not null,
  VALUE varchar(1024),
  TIMESTAMP bigint not null,
  constraint LOG_CONFIG_PROPERTY_UC1 unique (ID),
  constraint LOG_CONFIG_PROPERTY_FC1 foreign key (LOG_CONFIG_ID) references LOG_CONFIG(ID) ON DELETE CASCADE
);

create unique index LOG_CONFIG_PROPERTY_PK on LOG_CONFIG_PROPERTY(ID);
create unique index LOG_CONFIG_PROPERTY_AK1 on LOG_CONFIG_PROPERTY(LOG_CONFIG_ID, NAME);
create index LOG_CONFIG_PROPERTY_FK1 on LOG_CONFIG_PROPERTY(LOG_CONFIG_ID);


create cached table VCS_USER_TO_EMAIL_MAP (
  ID integer not null identity,
  BUILD_ID integer not null,
  USER_NAME varchar(254) not null,
  USER_EMAIL varchar(254),
  DISABLED varchar(3) not null,
  IM_ADDRESS varchar(100) null,
  IM_TYPE tinyint not null,
  TIMESTAMP bigint not null,
  constraint VCS_USER_TO_EMAIL_MAP_UC1 unique (ID),
  constraint VCS_USER_TO_EMAIL_MAP_FC1 foreign key (BUILD_ID) references BUILD_CONFIG(ID) ON DELETE CASCADE
);
create unique index VCS_USER_TO_EMAIL_MAP_PK on VCS_USER_TO_EMAIL_MAP(ID);
create unique index VCS_USER_TO_EMAIL_MAP_AK1 on VCS_USER_TO_EMAIL_MAP(BUILD_ID, USER_NAME);
create index VCS_USER_TO_EMAIL_MAP_FK1 on VCS_USER_TO_EMAIL_MAP(BUILD_ID);


create cached table BUILD_WATCHER (
  BUILD_ID integer not null,
  ID integer not null identity,
  EMAIL varchar(254) not null,
  LEVEL tinyint not null,
  DISABLED varchar(3) not null,
  IM_ADDRESS varchar(100) null,
  IM_TYPE tinyint not null,
  TIMESTAMP bigint not null,
  constraint BUILD_WATCHER_UC1 unique (ID),
  constraint BUILD_WATCHER_FC1 foreign key (BUILD_ID) references BUILD_CONFIG(ID) ON DELETE CASCADE
);
create unique index BUILD_WATCHER_PK on BUILD_WATCHER(ID);
create unique index BUILD_WATCHER_AK1 on BUILD_WATCHER(BUILD_ID, EMAIL);
create index BUILD_WATCHER_FK1 on BUILD_WATCHER(BUILD_ID);


create cached table BUILD_SEQUENCE (
  BUILD_ID integer not null,
  ID integer not null identity,
  NAME varchar(50) not null,
  SCRIPT varchar(1024) not null,
  SUCCESS_PATTERNS varchar(1024),
  FAILURE_PATTERNS varchar(1024),
  RESPECT_ERROR_CODE varchar(3) not null,
  TIMEOUT int not null,
  TIMESTAMP bigint not null,
  constraint BUILD_SEQUENCE_UC1 unique (ID),
  constraint BUILD_SEQUENCE_FC1 foreign key (BUILD_ID) references BUILD_CONFIG(ID) ON DELETE CASCADE
);
create unique index BUILD_SEQUENCE_PK on BUILD_SEQUENCE(ID);
create unique index BUILD_SEQUENCE_AK1 on BUILD_SEQUENCE(BUILD_ID, NAME);
create index BUILD_SEQUENCE_FK1 on BUILD_SEQUENCE(BUILD_ID);


create cached table SCHEDULE_ITEM (
  BUILD_ID integer not null,
  ID integer not null identity,
  HOUR varchar(3) not null,
  WEEK_DAY varchar(50) not null,
  MONTH_DAY varchar(50) not null,
  TIMESTAMP bigint not null,
  constraint SCHEDULE_ITEM_UC1 unique (ID),
  constraint SCHEDULE_ITEM_FC1 foreign key (BUILD_ID) references BUILD_CONFIG(ID) ON DELETE CASCADE
);
create unique index SCHEDULE_ITEM_PK on SCHEDULE_ITEM(ID);
create index SCHEDULE_ITEM_FK1 on SCHEDULE_ITEM(BUILD_ID);


create cached table ISSUE_TRACKER (
  BUILD_ID integer not null,
  ID integer not null identity,
  TYPE tinyint not null,
  TIMESTAMP bigint not null,
  constraint ISSUE_TRACKER_UC1 unique(ID),
  constraint ISSUE_TRACKER_FC1 foreign key (BUILD_ID) references BUILD_CONFIG(ID) ON DELETE CASCADE
);
create unique index ISSUE_TRACKER_PK on ISSUE_TRACKER(ID);
create index ISSUE_TRACKER_FK1 on ISSUE_TRACKER(BUILD_ID);


create cached table ISSUE_TRACKER_PROPERTY (
  ISSUE_TRACKER_ID integer not null,
  ID integer not null identity,
  NAME varchar(80) not null,
  VALUE varchar(1024),
  TIMESTAMP bigint not null,
  constraint ISSUE_TRACKER_PROPERTY_UC1 unique (ID),
  constraint ISSUE_TRACKER_PROPERTY_FC1 foreign key (ISSUE_TRACKER_ID) references ISSUE_TRACKER(ID) ON DELETE CASCADE
);
create unique index ISSUE_TRACKER_PROPERTY_PK on ISSUE_TRACKER_PROPERTY(ID);
create unique index ISSUE_TRACKER_PROPERTY_AK1 on ISSUE_TRACKER_PROPERTY(ISSUE_TRACKER_ID, NAME);
create index ISSUE_TRACKER_PROPERTY_FK1 on ISSUE_TRACKER_PROPERTY(ISSUE_TRACKER_ID);



create cached table BUILD_RUN (
  BUILD_ID integer not null,
  ID integer not null identity,
  NUMBER integer not null,
  COMPLETE tinyint not null,
  STARTED_AT datetime not null,
  FINISHED_AT datetime,
  RESULT  tinyint,
  RESULT_DESCRIPTION varchar(1024),
  LABEL  varchar(254) null,
  BUILD_NAME  varchar(254) not null,
  SYNC_NOTE  varchar(2048) not null,
  CHANGELIST_NUM  varchar(10) not null,
  LAST_STEP_NAME  varchar(50) not null,
  TIMESTAMP bigint not null,
  constraint BUILD_RUN_UC1 unique (ID),
  constraint BUILD_RUN_FC1 foreign key (BUILD_ID) references BUILD_CONFIG(ID) ON DELETE CASCADE
);
create unique index BUILD_RUN_PK on BUILD_RUN(ID);
create unique index BUILD_RUN_IX1 on BUILD_RUN(ID, COMPLETE);
create index BUILD_RUN_FK1 on BUILD_RUN(BUILD_ID);
create index BUILD_RUN_IX2 on BUILD_RUN(BUILD_ID, COMPLETE, RESULT);


create cached table BUILD_RUN_ATTRIBUTE (
  ID integer not null identity,
  BUILD_RUN_ID integer not null,
  NAME varchar(80) not null,
  VALUE varchar(1024),
  TIMESTAMP bigint not null,
  constraint BUILD_RUN_ATTRIBUTE_UC1 unique (ID),
  constraint BUILD_RUN_ATTRIBUTE_FC1 foreign key (BUILD_RUN_ID) references BUILD_RUN(ID) ON DELETE CASCADE
);
create unique index BUILD_RUN_ATTRIBUTE_PK on BUILD_RUN_ATTRIBUTE(ID);
create unique index BUILD_RUN_ATTRIBUTE_AK1 on BUILD_RUN_ATTRIBUTE(BUILD_RUN_ID, NAME);
create index BUILD_RUN_ATTRIBUTE_FK1 on BUILD_RUN_ATTRIBUTE(BUILD_RUN_ID);


create cached table STEP_RUN (
  BUILD_RUN_ID integer not null,
  ID integer not null identity,
  NAME varchar(100) not null,
  RESULT  tinyint,
  RESULT_DESCRIPTION varchar(1024),
  STARTED_AT datetime not null,
  FINISHED_AT datetime not null,
  LABEL  varchar(254) null,
  TIMESTAMP bigint not null,
  constraint STEP_RUN_UC1 unique (ID),
  constraint STEP_RUN_FC1 foreign key (BUILD_RUN_ID) references BUILD_RUN(ID) ON DELETE CASCADE
);
create unique index STEP_RUN_PK on STEP_RUN(ID);
create index STEP_RUN_FK1 on STEP_RUN(BUILD_RUN_ID);
create index STEP_RUN_IX1 on STEP_RUN(BUILD_RUN_ID, STARTED_AT);


create cached table STEP_RUN_ATTRIBUTE (
  ID integer not null identity,
  STEP_RUN_ID integer not null,
  NAME varchar(80) not null,
  VALUE varchar(1024),
  TIMESTAMP bigint not null,
  constraint STEP_RUN_ATTRIBUTE_UC1 unique (ID),
  constraint STEP_RUN_ATTRIBUTE_FC1 foreign key (STEP_RUN_ID) references STEP_RUN(ID) ON DELETE CASCADE
);
create unique index STEP_RUN_ATTRIBUTE_PK on STEP_RUN_ATTRIBUTE(ID);
create unique index STEP_RUN_ATTRIBUTE_AK1 on STEP_RUN_ATTRIBUTE(STEP_RUN_ID, NAME);
create index STEP_RUN_ATTRIBUTE_FK1 on STEP_RUN_ATTRIBUTE(STEP_RUN_ID);


create cached table STEP_LOG (
  STEP_RUN_ID integer not null,
  ID integer not null identity,
  FILE varchar(256) not null,
  PATH varchar(256) not null,
  DESCRIPTION varchar(1024) not null,
  TYPE tinyint not null,
  PATH_TYPE tinyint not null,
  FOUND tinyint not null,
  TIMESTAMP bigint not null,
  constraint STEP_LOG_UC1 unique (ID),
  constraint STEP_LOG_FC1 foreign key (STEP_RUN_ID) references STEP_RUN(ID) ON DELETE CASCADE
);
create index STEP_LOG_IX1 on STEP_LOG(STEP_RUN_ID, TYPE);
create index STEP_LOG_FK1 on STEP_LOG(STEP_RUN_ID);


create cached table CHANGELIST (
  ID integer not null identity,
  CREATED datetime not null,
  NUMBER varchar(10) null,
  EMAIL varchar(50) null,
  USER varchar(50) not null,
  CLIENT varchar(50) null,
  BRANCH varchar(50) null,
  DESCRIPTION varchar(1024) not null,
  constraint CHANGELIST_UC1 unique (ID)
)
create unique index CHANGELIST_PK on CHANGELIST(ID);
create index CHANGELIST_IX1 on CHANGELIST(CREATED);


create cached table BUILD_CHANGELIST (
  ID integer not null identity,
  BUILD_ID integer not null,
  CHANGELIST_CREATED datetime not null,
  CHANGELIST_ID integer not null,
  NEW char(1) not null,
  constraint BUILD_CHANGELIST_UC1 unique (ID),
  constraint BUILD_CHANGELIST_FC1 foreign key (BUILD_ID) references BUILD_CONFIG(ID) ON DELETE CASCADE,
  constraint BUILD_CHANGELIST_FC2 foreign key (CHANGELIST_ID) references CHANGELIST(ID) ON DELETE CASCADE
)
create unique index BUILD_CHANGELIST_PK on BUILD_CHANGELIST(ID);
create index BUILD_CHANGELIST_FK1 on BUILD_CONFIG(ID);
create index BUILD_CHANGELIST_FK2 on CHANGELIST(ID);
create unique index BUILD_CHANGELIST_IX1 on BUILD_CHANGELIST(BUILD_ID, CHANGELIST_ID);
create index BUILD_CHANGELIST_IX2 on BUILD_CHANGELIST(BUILD_ID, NEW, CHANGELIST_CREATED);


create cached table BUILD_RUN_PARTICIPANT (
  BUILD_RUN_ID integer not null,
  CHANGELIST_ID integer not null,
  ID integer not null identity,
  constraint BUILD_RUN_PARTICIPANT_UC1 unique (ID),
  constraint BUILD_RUN_PARTICIPANT_FC1 foreign key (BUILD_RUN_ID) references BUILD_RUN(ID) ON DELETE CASCADE,
  constraint BUILD_RUN_PARTICIPANT_FC2 foreign key (CHANGELIST_ID) references CHANGELIST(ID) ON DELETE CASCADE
)
create unique index BUILD_RUN_PARTICIPANT_PK on BUILD_RUN_PARTICIPANT(ID);
create index BUILD_RUN_PARTICIPANT_IX1 on BUILD_RUN_PARTICIPANT(BUILD_RUN_ID, CHANGELIST_ID);
create index BUILD_RUN_PARTICIPANT_FK1 on BUILD_RUN_PARTICIPANT(BUILD_RUN_ID);
create index BUILD_RUN_PARTICIPANT_FK2 on BUILD_RUN_PARTICIPANT(CHANGELIST_ID);


create cached table CHANGE (
  CHANGELIST_ID integer not null,
  ID integer not null identity,
  REVISION varchar(100) not null,
  TYPE tinyint not null,
  FILE_PATH varchar(1024) not null,
  constraint CHANGE_UC1 unique (ID),
  constraint CHANGE_FC1 foreign key (CHANGELIST_ID) references CHANGELIST(ID) ON DELETE CASCADE
)
create unique index CHANGE_PK on CHANGE(ID);
create index CHANGE_FK1 on CHANGE(CHANGELIST_ID);


create cached table ISSUE (
  ID integer not null identity,
  TRACKER_TYPE tinyint not null,
  KEY varchar(50) not null,
  DESCRIPTION varchar(100) not null,
  PRODUCT varchar(50) default '' not null,
  VERSION varchar(50) default '' not null,
  PROJECT varchar(50) default '' not null,
  STATUS varchar(50) default '' not null,
  PRIORITY varchar(50) default '' not null,
  CLOSED datetime null,
  CLOSED_BY varchar(50) null,
  RECEIVED datetime not null,
  URL varchar(200) null, 
  constraint ISSUE_UC1 unique (ID)
)
create unique index ISSUE_PK on ISSUE(ID);
create index ISSUE_IX1 on ISSUE(KEY);
create index ISSUE_IX2 on ISSUE(TRACKER_TYPE, KEY, PRODUCT, VERSION);
create index ISSUE_IX3 on ISSUE(TRACKER_TYPE, KEY, PROJECT, VERSION);


create cached table ISSUE_ATTR (
  ID integer not null identity,
  ISSUE_ID integer not null,
  NAME varchar(80) not null,
  VALUE varchar(1024),
  constraint ISSUE_ATTR_UC1 unique (ID),
  constraint ISSUE_ATTR_FC1 foreign key (ISSUE_ID) references ISSUE(ID) ON DELETE CASCADE
);
create unique index ISSUE_ATTR_PK on ISSUE_ATTR(ID);
create unique index ISSUE_ATTR_AK1 on ISSUE_ATTR(ISSUE_ID, NAME);
create index ISSUE_ATTR_FK1 on ISSUE_ATTR(ISSUE_ID);


create cached table PENDING_ISSUE (
  ID integer not null identity,
  BUILD_ID integer not null,
  ISSUE_ID integer not null,
  constraint PENDING_ISSUE_UC1 unique (ID),
  constraint PENDING_ISSUE_FC1 foreign key (BUILD_ID) references BUILD_CONFIG(ID) ON DELETE CASCADE,
  constraint PENDING_ISSUE_FC2 foreign key (ISSUE_ID) references ISSUE(ID) ON DELETE CASCADE
)
create unique index PENDING_ISSUE_PK on PENDING_ISSUE(ID);
create unique index PENDING_ISSUE_AK1 on PENDING_ISSUE(BUILD_ID, ISSUE_ID);
create index PENDING_ISSUE_FK1 on PENDING_ISSUE(BUILD_ID);
create index PENDING_ISSUE_FK2 on PENDING_ISSUE(ISSUE_ID);


create cached table ISSUE_CHANGELIST (
  ID integer not null identity,
  ISSUE_ID integer not null,
  CHANGELIST_ID integer not null,
  constraint ISSUE_CHANGELIST_UC1 unique (ID),
  constraint ISSUE_CHANGELIST_FC1 foreign key (ISSUE_ID) references ISSUE(ID) ON DELETE CASCADE,
  constraint ISSUE_CHANGELIST_FC2 foreign key (CHANGELIST_ID) references CHANGELIST(ID) ON DELETE CASCADE
)
create unique index ISSUE_CHANGELIST_PK on ISSUE_CHANGELIST(ID);
create unique index ISSUE_CHANGELIST_AK1 on ISSUE_CHANGELIST(ISSUE_ID, CHANGELIST_ID);
create index ISSUE_CHANGELIST_FK1 on ISSUE_CHANGELIST(ISSUE_ID);
create index ISSUE_CHANGELIST_FK2 on ISSUE_CHANGELIST(CHANGELIST_ID);


create cached table RELEASE_NOTE (
  ID integer not null identity,
  BUILD_RUN_ID integer not null,
  ISSUE_ID integer not null,
  constraint RELEASE_NOTE_UC1 unique (ID),
  constraint RELEASE_NOTE_FC1 foreign key (BUILD_RUN_ID) references BUILD_RUN(ID) ON DELETE CASCADE,
  constraint RELEASE_NOTE_FC2 foreign key (ISSUE_ID) references ISSUE(ID) ON DELETE CASCADE
)
create unique index RELEASE_NOTE_PK on RELEASE_NOTE(ID);
create unique index RELEASE_NOTE_AK1 on RELEASE_NOTE(BUILD_RUN_ID, ISSUE_ID);
create index RELEASE_NOTE_FK1 on RELEASE_NOTE(BUILD_RUN_ID);
create index RELEASE_NOTE_FK2 on RELEASE_NOTE(ISSUE_ID);


insert into USERS (ID, NAME, FNAME, PASSWORD, IS_ADMIN, EMAIL, ROLES, ENABLED, IM_TYPE, IM_ADDRESS, TIMESTAMP) values(1, 'admin', '', '21232F297A57A5A743894A0E4A801FC3', 'Y', '', 'admin', 'Y', 0, '', 1);
insert into SYSTEM_PROPERTY (ID, NAME, VALUE, TIMESTAMP) values (1, 'parabuild.schema.version', '3', 1);
insert into SYSTEM_PROPERTY (ID, NAME, VALUE, TIMESTAMP) values (2, 'parabuild.date.format', 'MM/dd/yyyy', 1);
insert into SYSTEM_PROPERTY (ID, NAME, VALUE, TIMESTAMP) values (3, 'parabuild.date.time.format', 'hh:mm a MM/dd/yyyy', 1);
