
    create table public.Match (
       id  serial not null,
        description varchar(255),
        match_date date not null,
        match_time time not null,
        sport int4 not null,
        team_a varchar(255) not null,
        team_b varchar(255) not null,
        primary key (id)
    );

    create table public.MatchOdds (
       id  serial not null,
        odd float4 not null,
        specifier char(1) not null,
        match_id int4 not null,
        primary key (id)
    );

    alter table public.MatchOdds 
       add constraint FKnmauvx9m3vbgbgommxmapqd48 
       foreign key (match_id) 
       references public.Match 
       on delete cascade;
