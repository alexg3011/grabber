CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

select person.name, company.name
from person
join company on person.company_id = company.id
where company.id != 5;

select company.name as company_name, count(*) as people_count
from company
join person on company.id = person.company_id
group by company.company_name
order by people_count desc
limit 1;

