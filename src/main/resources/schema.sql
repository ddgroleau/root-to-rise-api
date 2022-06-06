-- Table: public.products

-- DROP TABLE IF EXISTS public.products;

CREATE TABLE IF NOT EXISTS public.products
(
    product_id serial,
    name character varying(255) COLLATE pg_catalog."default",
    type character varying(255) COLLATE pg_catalog."default",
    value_proposition character varying(255) COLLATE pg_catalog."default",
    description character varying(255) COLLATE pg_catalog."default",
    use_cases character varying(255) COLLATE pg_catalog."default",
    disclaimer character varying(255) COLLATE pg_catalog."default",
    image_path character varying(255) COLLATE pg_catalog."default",
    instructions character varying(255) COLLATE pg_catalog."default",
    price double precision,
    stock_quantity integer,
    measurement_size double precision,
    measurement_unit character varying(255) COLLATE pg_catalog."default",
    created_by character varying(255) COLLATE pg_catalog."default",
    created_on timestamp without time zone,
    updated_by character varying(255) COLLATE pg_catalog."default",
    updated_on timestamp without time zone,
    CONSTRAINT products_pkey PRIMARY KEY (product_id)
)

TABLESPACE pg_default;

-- ALTER TABLE IF EXISTS public.products
--     OWNER to root;

-- Table: public.ingredients

-- DROP TABLE IF EXISTS public.ingredients;

CREATE TABLE IF NOT EXISTS public.ingredients
(
    ingredient_id serial,
    product_id integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    alternate_name character varying(255) COLLATE pg_catalog."default",
    type character varying(255) COLLATE pg_catalog."default",
    description character varying(255) COLLATE pg_catalog."default",
    display_order integer,
    image_path character varying(255) COLLATE pg_catalog."default",
    created_by character varying(255) COLLATE pg_catalog."default",
    created_on timestamp without time zone,
    updated_by character varying(255) COLLATE pg_catalog."default",
    updated_on timestamp without time zone,
    CONSTRAINT ingredients_pkey PRIMARY KEY (ingredient_id),
    CONSTRAINT fk34jbb91wprx6ys2443vf43cxj FOREIGN KEY (product_id)
        REFERENCES public.products (product_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

-- ALTER TABLE IF EXISTS public.ingredients
--     OWNER to root;

-- Table: public.properties

-- DROP TABLE IF EXISTS public.properties;

CREATE TABLE IF NOT EXISTS public.properties
(
    property_id serial,
    product_id integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    description character varying(255) COLLATE pg_catalog."default",
    created_by character varying(255) COLLATE pg_catalog."default",
    created_on timestamp without time zone,
    updated_by character varying(255) COLLATE pg_catalog."default",
    updated_on timestamp without time zone,
    CONSTRAINT properties_pkey PRIMARY KEY (property_id),
    CONSTRAINT fkqbtxtswifwbjcu98cciemunyf FOREIGN KEY (product_id)
        REFERENCES public.products (product_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

-- ALTER TABLE IF EXISTS public.properties
--     OWNER to root;

-- Table: public.traits

-- DROP TABLE IF EXISTS public.traits;

CREATE TABLE IF NOT EXISTS public.traits
(
    trait_id serial,
    product_id integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    description character varying(255) COLLATE pg_catalog."default",
    created_by character varying(255) COLLATE pg_catalog."default",
    created_on timestamp without time zone,
    updated_by character varying(255) COLLATE pg_catalog."default",
    updated_on timestamp without time zone,
    CONSTRAINT traits_pkey PRIMARY KEY (trait_id),
    CONSTRAINT fktn7xqowg13qfdcsedjg6bpate FOREIGN KEY (product_id)
        REFERENCES public.products (product_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

-- ALTER TABLE IF EXISTS public.traits
--     OWNER to root;
