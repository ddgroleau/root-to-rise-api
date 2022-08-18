-- STORED PROCS

-- PROCEDURE: public.insert_product
drop procedure IF EXISTS public.insert_product(
character varying,
character varying,
character varying,
character varying,
double precision,
character varying,
character varying,
double precision,
integer,
character varying,
character varying,
character varying
);

create or replace procedure public.insert_product(
    IN description character varying,
    IN disclaimer character varying,
    IN image_path character varying,
    IN instructions character varying,
    IN measurement_size double precision,
    IN measurement_unit character varying,
    IN name character varying,
    IN price double precision,
    IN stock_quantity integer,
    IN type character varying,
    IN use_cases character varying,
    IN value_proposition character varying
    )
LANGUAGE plpgsql
AS '
BEGIN
INSERT INTO public.products(
    created_by,
    created_on,
    description,
    disclaimer,
    image_path,
    instructions,
    measurement_size,
    measurement_unit,
    name,
    price,
    stock_quantity,
    type,
    updated_by,
    updated_on,
    use_cases,
    value_proposition
    )
	VALUES (
        ''root'', -- created_by
        CURRENT_DATE, --created_on
        description, --description
        disclaimer, --disclaimer
        image_path, --image_path
        instructions, --instructions
        measurement_size, --measurement_size
        measurement_unit, --measurement_unit
        name, --name
        price, --price
        stock_quantity, --stock_quantity
        type, --type
        ''root'', --updated_by
        CURRENT_DATE, --updated_on
        use_cases, --use_cases
        value_proposition --value_proposition
    );
END
';
-- ALTER PROCEDURE public.insert_product(
--    IN description character varying,
--    IN disclaimer character varying,
--    IN image_path character varying,
--    IN instructions character varying,
--    IN measurement_size double precision,
--    IN measurement_unit character varying,
--    IN name character varying,
--    IN price double precision,
--    IN stock_quantity integer,
--    IN type character varying,
--    IN use_cases character varying,
--    IN value_proposition character varying
--    )
--     OWNER TO root;

-- PROCEDURE: public.insert_ingredient
drop procedure IF EXISTS public.insert_ingredient(
character varying,
character varying,
character varying,
character varying,
character varying,
integer,
character varying
);

create or replace procedure public.insert_ingredient(
    IN product_name character varying,
    IN ingredient_name character varying,
    IN alternate_name character varying,
    IN type character varying,
    IN description character varying,
    IN display_order integer,
    IN image_path character varying
)
LANGUAGE plpgsql
AS '
BEGIN
INSERT INTO public.ingredients(
	product_id, name, alternate_name, type, description, display_order, image_path, created_by, created_on, updated_by, updated_on)
VALUES
(
    (SELECT product_id from public.products WHERE name = product_name LIMIT 1), --product_id
    ingredient_name, --name
    alternate_name, --alternate_name
    type, --type
    description, --description
    display_order, --display_order
    image_path, --image_path
    ''root'', --created_by
    CURRENT_DATE, --created_on
    ''root'', --updated_by
    CURRENT_DATE --updated_on
);
END
';
-- ALTER PROCEDURE public.insert_ingredient(
--    IN product_name character varying,
--    IN ingredient_name character varying,
--    IN alternate_name character varying,
--    IN type character varying,
--    IN description character varying,
--    IN display_order integer,
--    IN image_path character varying
--)
--     OWNER TO root;

-- PROCEDURE: public.insert_property(character varying, character varying)
DROP procedure IF EXISTS public.insert_property(character varying, character varying);

create or replace procedure public.insert_property(IN property_name character varying,IN product_name character varying)
LANGUAGE plpgsql
AS '
BEGIN
    INSERT INTO public.properties(product_id, name, description, created_by, created_on, updated_by, updated_on)
    VALUES
    (
        (SELECT product_id from public.products WHERE name = product_name LIMIT 1), --product_id
        property_name, --name
        null, --description
        ''root'', --created_by
        CURRENT_DATE, --created_on
        ''root'', --updated_by
        CURRENT_DATE  --updated_on
    );
END
';
-- ALTER PROCEDURE public.insert_property(character varying, character varying)
--     OWNER TO root;

-- PROCEDURE: public.insert_property(character varying, character varying)

DROP procedure IF EXISTS public.insert_trait(character varying, character varying);

create or replace procedure public.insert_trait(IN trait_name character varying,IN product_name character varying)
LANGUAGE plpgsql
AS '
BEGIN
    INSERT INTO public.traits(product_id, name, description, created_by, created_on, updated_by, updated_on)
    VALUES
    (
        (SELECT product_id from public.products WHERE name = product_name LIMIT 1), --product_id
        trait_name, --name
        null, --description
        ''root'', --created_by
        CURRENT_DATE, --created_on
        ''root'', --updated_by
        CURRENT_DATE  --updated_on
    );
END
';
-- ALTER PROCEDURE public.insert_property(character varying, character varying)
--     OWNER TO root;
