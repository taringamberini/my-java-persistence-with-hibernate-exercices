
    alter table MESSAGES 
        drop constraint FK_496cc02ef9a142e5a2ee744b220;

    drop table MESSAGES if exists;

    create table MESSAGES (
        MESSAGE_ID bigint generated by default as identity (start with 1),
        MESSAGE_TEXT varchar(255),
        NEXT_MESSAGE_ID bigint,
        primary key (MESSAGE_ID)
    );

    alter table MESSAGES 
        add constraint FK_496cc02ef9a142e5a2ee744b220 
        foreign key (NEXT_MESSAGE_ID) 
        references MESSAGES;
