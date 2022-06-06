-- START Products

INSERT INTO public.products(
	name, type, value_proposition, description, use_cases, disclaimer, image_path, instructions, price, stock_quantity,
    measurement_size, measurement_unit, created_by, created_on, updated_by, updated_on)
VALUES
(
    'Ground Down Tincture', --name
    'tincture', --type
    'Our Ground Down tincture was designed with your stress in mind. During those moments of feeling wound up, overworked, anxious, or burnt out, our blend was designed to help ground you back down to Mother Earth.', --value_proposition
    'Ground Down includes a blend of nervines such as skullcap, oatstraw, and lavender, mixed with powerful adapogens like ashwagandha and tulsi. Together, these herbs can help you feel unstuck, calm your nerves and settle you back.', --description
    'May help to uplift mood & energy, and relieve exhaustion. May help with relieve feelings of anxiety and stress. May aid in overcoming chronic stress. May ground and bring you into bodily presence.', --use_cases
    'Do not consume if you are pregnant, have celiac disease or gluten-free, or taking any sedative medications.', --disclaimer
    'ground-down.jpg', --image_path
    'Take dropper-full as needed up to 3 times per day. Add directly onto or under your tongue, into your tea or coffee, in your smoothie or juice whenever you''re feeling anxious or stressed.', --instructions
    19, --price
    15, --stock_quantity
    1, --measurement_size
    'oz', --measurement_unit
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    'Tummy Tamer Tincture', --name
    'tincture', --type
    '', --value_proposition
    '', --description
    '', --use_cases
    '', --disclaimer
    'tummy-tamer.jpg', --image_path
    'Take dropper-full as needed after a meal or before bed. Add directly onto or under your tongue, into your tea or coffee, in your smoothie or juice whenever your digestive system needs a little assist.', --instructions
    19, --price
    15, --stock_quantity
    1, --measurement_size
    'oz', --measurement_unit
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    'Dream Land Tincture', --name
    'tincture', --type
    '', --value_proposition
    '', --description
    '', --use_cases
    '', --disclaimer
    'dream-land.jpg', --image_path
    '', --instructions
    19, --price
    6, --stock_quantity
    1, --measurement_size
    'oz', --measurement_unit
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    'Breathe Easy Tincture', --name
    'tincture', --type
    '', --value_proposition
    '', --description
    '', --use_cases
    '', --disclaimer
    'breathe-easy.jpg', --image_path
    '', --instructions
    19, --price
    9, --stock_quantity
    1, --measurement_size
    'oz', --measurement_unit
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    'Spring SnEase Tincture', --name
    'tincture', --type
    '', --value_proposition
    '', --description
    '', --use_cases
    '', --disclaimer
    'spring-snease.jpg', --image_path
    '', --instructions
    19, --price
    15, --stock_quantity
    1, --measurement_size
    'oz', --measurement_unit
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    'Head Aid Tincture', --name
    'tincture', --type
    '', --value_proposition
    '', --description
    '', --use_cases
    '', --disclaimer
    'head-aid.jpg', --image_path
    '', --instructions
    19, --price
    11, --stock_quantity
    1, --measurement_size
    'oz', --measurement_unit
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    'Dandy Bitters', --name
    'bitters', --type
    '', --value_proposition
    '', --description
    '', --use_cases
    '', --disclaimer
    'dandy.jpg', --image_path
    '', --instructions
    17, --price
    2, --stock_quantity
    1, --measurement_size
    'oz', --measurement_unit
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
);

-- END Products

-- START Ingredients

INSERT INTO public.ingredients(
	product_id, name, alternate_name, type, description, display_order, image_path, created_by, created_on, updated_by, updated_on)
VALUES
-- Ground Down Tincture
(
    (SELECT product_id from public.products WHERE name = 'Ground Down Tincture' LIMIT 1), --product_id
    'Tulsi', --name
    'Ocimum tenuiflorum', --alternate_name
    'herb', --type
    null, --description
    1, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Ground Down Tincture' LIMIT 1), --product_id
    'Ashwagandha', --name
    'Withania somnifera', --alternate_name
    'herb', --type
    null, --description
    2, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Ground Down Tincture' LIMIT 1), --product_id
    'Lavender', --name
    'Lavandula spp.', --alternate_name
    'herb', --type
    null, --description
    3, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Ground Down Tincture' LIMIT 1), --product_id
    'Oatstraw', --name
    'Avena sativa', --alternate_name
    'herb', --type
    null, --description
    4, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Ground Down Tincture' LIMIT 1), --product_id
    'Skullcap', --name
    'Scutellaria lateriflora', --alternate_name
    'herb', --type
    null, --description
    5, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Ground Down Tincture' LIMIT 1), --product_id
    'Grain Alcohol', --name
    null, --alternate_name
    'alcohol', --type
    null, --description
    6, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
-- Tummy Tamer Tincture
(
    (SELECT product_id from public.products WHERE name = 'Tummy Tamer Tincture' LIMIT 1), --product_id
    'Peppermint', --name
    'Mentha × piperita', --alternate_name
    'herb', --type
    null, --description
    1, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Tummy Tamer Tincture' LIMIT 1), --product_id
    'Ginger Root', --name
    'Zingiber officinale', --alternate_name
    'herb', --type
    null, --description
    2, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Tummy Tamer Tincture' LIMIT 1), --product_id
    'Fennel Seed', --name
    'Foeniculum vulgare', --alternate_name
    'herb', --type
    null, --description
    3, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Tummy Tamer Tincture' LIMIT 1), --product_id
    'Senna', --name
    'Senna alexandrina', --alternate_name
    'herb', --type
    null, --description
    4, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Tummy Tamer Tincture' LIMIT 1), --product_id
    'Grain Alcohol', --name
    null, --alternate_name
    'alcohol', --type
    null, --description
    5, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
--Dream Land Tincture
(
    (SELECT product_id from public.products WHERE name = 'Dream Land Tincture' LIMIT 1), --product_id
    'Valerian', --name
    'Valeriana officinalis', --alternate_name
    'herb', --type
    null, --description
    1, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Dream Land Tincture' LIMIT 1), --product_id
    'Chamomile', --name
    'Matricaria chamomilla', --alternate_name
    'herb', --type
    null, --description
    2, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Dream Land Tincture' LIMIT 1), --product_id
    'Catnip', --name
    'Nepeta cataria', --alternate_name
    'herb', --type
    null, --description
    3, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Dream Land Tincture' LIMIT 1), --product_id
    'Lemon Balm', --name
    'Melissa officinalis', --alternate_name
    'herb', --type
    null, --description
    4, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Dream Land Tincture' LIMIT 1), --product_id
    'Grain Alcohol', --name
    null, --alternate_name
    'alcohol', --type
    null, --description
    5, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
-- Breathe Easy Tincture
(
    (SELECT product_id from public.products WHERE name = 'Breathe Easy Tincture' LIMIT 1), --product_id
    'Licorice Root', --name
    'Glycyrrhiza glabra', --alternate_name
    'herb', --type
    null, --description
    1, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Breathe Easy Tincture' LIMIT 1), --product_id
    'Cinnamon', --name
    'Cinnamomum cassia', --alternate_name
    'herb', --type
    null, --description
    2, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Breathe Easy Tincture' LIMIT 1), --product_id
    'Echinacea Root', --name
    'Echinacea angustifolia', --alternate_name
    'herb', --type
    null, --description
    3, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Breathe Easy Tincture' LIMIT 1), --product_id
    'Marshmallow Root', --name
    'Althaea officinalis', --alternate_name
    'herb', --type
    null, --description
    4, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Breathe Easy Tincture' LIMIT 1), --product_id
    'Elecampane Root', --name
    'Inula helenium', --alternate_name
    'herb', --type
    null, --description
    5, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Breathe Easy Tincture' LIMIT 1), --product_id
    'Ginger Root', --name
    'Zingiber officinale', --alternate_name
    'herb', --type
    null, --description
    6, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Breathe Easy Tincture' LIMIT 1), --product_id
    'Grain Alcohol', --name
    null, --alternate_name
    'alcohol', --type
    null, --description
    7, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
-- Spring SnEase Tincture
(
    (SELECT product_id from public.products WHERE name = 'Spring SnEase Tincture' LIMIT 1), --product_id
    'Elder Flower', --name
    'Sambucus nigra L. ssp. canadensis', --alternate_name
    'herb', --type
    null, --description
    1, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Spring SnEase Tincture' LIMIT 1), --product_id
    'Nettle Leaf', --name
    'Urtica dioica', --alternate_name
    'herb', --type
    null, --description
    2, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Spring SnEase Tincture' LIMIT 1), --product_id
    'Ginger Root', --name
    'Zingiber officinale', --alternate_name
    'herb', --type
    null, --description
    3, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Spring SnEase Tincture' LIMIT 1), --product_id
    'Reishi Mushroom', --name
    'Ganoderma lucidum', --alternate_name
    'herb', --type
    null, --description
    4, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Spring SnEase Tincture' LIMIT 1), --product_id
    'Milk Thistle', --name
    'Silybum marianum', --alternate_name
    'herb', --type
    null, --description
    5, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Spring SnEase Tincture' LIMIT 1), --product_id
    'Grain Alcohol', --name
    null, --alternate_name
    'alcohol', --type
    null, --description
    6, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
-- Head Aid Tincture
(
    (SELECT product_id from public.products WHERE name = 'Head Aid Tincture' LIMIT 1), --product_id
    'Willow  Bark', --name
    'Salix alba', --alternate_name
    'herb', --type
    null, --description
    1, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Head Aid Tincture' LIMIT 1), --product_id
    'Lemon Balm', --name
    'Melissa officinalis', --alternate_name
    'herb', --type
    null, --description
    2, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Head Aid Tincture' LIMIT 1), --product_id
    'Catnip', --name
    'Nepeta cataria', --alternate_name
    'herb', --type
    null, --description
    3, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Head Aid Tincture' LIMIT 1), --product_id
    'California Poppy', --name
    'Eschscholzia californica', --alternate_name
    'herb', --type
    null, --description
    4, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Head Aid Tincture' LIMIT 1), --product_id
    'Skullcap', --name
    'Scutellaria lateriflora', --alternate_name
    'herb', --type
    null, --description
    5, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Head Aid Tincture' LIMIT 1), --product_id
    'Grain Alcohol', --name
    null, --alternate_name
    'alcohol', --type
    null, --description
    6, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
-- Dandy Bitters
(
    (SELECT product_id from public.products WHERE name = 'Dandy Bitters' LIMIT 1), --product_id
    'Dandelion Root', --name
    'Taraxacum officinale', --alternate_name
    'herb', --type
    null, --description
    1, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Dandy Bitters' LIMIT 1), --product_id
    'Chamomile', --name
    'Matricaria chamomilla', --alternate_name
    'herb', --type
    null, --description
    2, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Dandy Bitters' LIMIT 1), --product_id
    'Fennel Seed', --name
    'Foeniculum vulgare', --alternate_name
    'herb', --type
    null, --description
    3, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Dandy Bitters' LIMIT 1), --product_id
    'Orange Peel', --name
    'Citrus sinensis', --alternate_name
    'herb', --type
    null, --description
    4, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
),
(
    (SELECT product_id from public.products WHERE name = 'Dandy Bitters' LIMIT 1), --product_id
    'Grain Alcohol', --name
    null, --alternate_name
    'alcohol', --type
    null, --description
    5, --display_order
    null, --image_path
    'root', --created_by
    CURRENT_DATE, --created_on
    'root', --updated_by
    CURRENT_DATE --updated_on
);

--END Ingredients
