-- Table: public.products

DROP TABLE IF EXISTS public.products;

CREATE TABLE IF NOT EXISTS public.products
(
    product_id SERIAL,
    name character varying(90) COLLATE pg_catalog."default",
    measurement_size integer,
    measurement_unit character varying(90) COLLATE pg_catalog."default",
    stock_quantity integer,
    price double precision,
    description character varying(1000) COLLATE pg_catalog."default",
    disclaimer character varying(2000) COLLATE pg_catalog."default",
    image_path character varying(90) COLLATE pg_catalog."default",
    ingredients character varying(2000) COLLATE pg_catalog."default",
    instructions character varying(2000) COLLATE pg_catalog."default",
    use_cases character varying(2000) COLLATE pg_catalog."default",
    created_by character varying(90) COLLATE pg_catalog."default",
    created_on timestamp without time zone,
    updated_by character varying(90) COLLATE pg_catalog."default",
    updated_on timestamp without time zone,
    CONSTRAINT products_pkey PRIMARY KEY (product_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.products
    OWNER to root;