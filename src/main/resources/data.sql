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

--START Properties

call insert_property('Adaptogen','Ground Down Tincture');
call insert_property('Alterative','Ground Down Tincture');
call insert_property('Antibacterial','Ground Down Tincture');
call insert_property('Anticancer','Ground Down Tincture');
call insert_property('Antidepressant','Ground Down Tincture');
call insert_property('Antifungal','Ground Down Tincture');
call insert_property('Antioxidant','Ground Down Tincture');
call insert_property('Antispasmodic','Ground Down Tincture');
call insert_property('Antiviral','Ground Down Tincture');
call insert_property('Anxiolytic','Ground Down Tincture');
call insert_property('Carminative','Ground Down Tincture');
call insert_property('Decongestant','Ground Down Tincture');
call insert_property('Emmenagogue','Ground Down Tincture');
call insert_property('Expectorant','Ground Down Tincture');
call insert_property('Galactogogue','Ground Down Tincture');
call insert_property('Immunomodulant','Ground Down Tincture');
call insert_property('Nervine','Ground Down Tincture');
call insert_property('Radioprotective','Ground Down Tincture');
call insert_property('Tonic','Ground Down Tincture');
call insert_property('Stimulant','Ground Down Tincture');
call insert_property('Taste','Ground Down Tincture');
call insert_property('Sedative','Ground Down Tincture');
call insert_property('Circulatory Stimulant','Ground Down Tincture');
call insert_property('Aphrodisiac','Ground Down Tincture');
call insert_property('Cardiotonic','Ground Down Tincture');
call insert_property('Demulcent','Ground Down Tincture');
call insert_property('Emollient','Ground Down Tincture');
call insert_property('Hypocholesterolemic','Ground Down Tincture');
call insert_property('Reproductive tonic','Ground Down Tincture');
call insert_property('Trophorestorative','Ground Down Tincture');
call insert_property('Nutritive','Ground Down Tincture');
call insert_property('Analgesic','Ground Down Tincture');
call insert_property('Bitter','Ground Down Tincture');
call insert_property('Hypotensive','Ground Down Tincture');
call insert_property('Relaxant','Ground Down Tincture');
call insert_property('Trophorestorative','Ground Down Tincture');
call insert_property('Antispasmodic','Tummy Tamer Tincture');
call insert_property('Carminative','Tummy Tamer Tincture');
call insert_property('Antimicrobial','Tummy Tamer Tincture');
call insert_property('Analgesic','Tummy Tamer Tincture');
call insert_property('Diuretic','Tummy Tamer Tincture');
call insert_property('Stimulant','Tummy Tamer Tincture');
call insert_property('Nervine','Tummy Tamer Tincture');
call insert_property('Anti-emetic','Tummy Tamer Tincture');
call insert_property('Antispasmodic','Tummy Tamer Tincture');
call insert_property('Carminative','Tummy Tamer Tincture');
call insert_property('Antimicrobial','Tummy Tamer Tincture');
call insert_property('Analgesic','Tummy Tamer Tincture');
call insert_property('Diaphoretic','Tummy Tamer Tincture');
call insert_property('Stimulant','Tummy Tamer Tincture');
call insert_property('Nervine','Tummy Tamer Tincture');
call insert_property('Anti-emetic','Tummy Tamer Tincture');
call insert_property('Antiviral','Tummy Tamer Tincture');
call insert_property('Anti-inflammatory','Tummy Tamer Tincture');
call insert_property('Galactogogue','Tummy Tamer Tincture');
call insert_property('Expectorant','Tummy Tamer Tincture');
call insert_property('Emmenagogue','Tummy Tamer Tincture');
call insert_property('Parasiticide','Tummy Tamer Tincture');
call insert_property('Circulatory Stimulant','Tummy Tamer Tincture');
call insert_property('Radioprotective','Tummy Tamer Tincture');
call insert_property('Antispasmodic','Dream Land Tincture');
call insert_property('Anxiolytic','Dream Land Tincture');
call insert_property('Antidepressant','Dream Land Tincture');
call insert_property('Analgesic','Dream Land Tincture');
call insert_property('Nervine','Dream Land Tincture');
call insert_property('Neuroprotective','Dream Land Tincture');
call insert_property('Relaxant','Dream Land Tincture');
call insert_property('Sedative','Dream Land Tincture');
call insert_property('Soporific','Dream Land Tincture');
call insert_property('Anti-inflammatory','Dream Land Tincture');
call insert_property('Bitter','Dream Land Tincture');
call insert_property('Carminative','Dream Land Tincture');
call insert_property('Vulnerary','Dream Land Tincture');
call insert_property('Aperient','Dream Land Tincture');
call insert_property('Diaphoretic','Dream Land Tincture');
call insert_property('Emmenagogue','Dream Land Tincture');
call insert_property('Stimulant','Dream Land Tincture');
call insert_property('Stomachic','Dream Land Tincture');
call insert_property('Tonic','Dream Land Tincture');
call insert_property('Antimicrobial','Dream Land Tincture');
call insert_property('Antioxidant','Dream Land Tincture');
call insert_property('Antiviral','Dream Land Tincture');
call insert_property('Radioprotective','Dream Land Tincture');
call insert_property('Trophorestorative','Dream Land Tincture');
call insert_property('Anti-emetic','Breathe Easy Tincture');
call insert_property('Antiviral','Breathe Easy Tincture');
call insert_property('Anti-inflammatory','Breathe Easy Tincture');
call insert_property('Carminative','Breathe Easy Tincture');
call insert_property('Antispasmodic','Breathe Easy Tincture');
call insert_property('Circulatory Stimulant','Breathe Easy Tincture');
call insert_property('Radioprotective','Breathe Easy Tincture');
call insert_property('Adaptogen','Breathe Easy Tincture');
call insert_property('Antibacterial','Breathe Easy Tincture');
call insert_property('Diaphoretic','Breathe Easy Tincture');
call insert_property('Demulcent','Breathe Easy Tincture');
call insert_property('Hepatic','Breathe Easy Tincture');
call insert_property('Tonic','Breathe Easy Tincture');
call insert_property('Antioxidant','Breathe Easy Tincture');
call insert_property('Analgesic','Breathe Easy Tincture');
call insert_property('Alterative','Breathe Easy Tincture');
call insert_property('Expectorant','Breathe Easy Tincture');
call insert_property('Digestive','Breathe Easy Tincture');
call insert_property('Emmenagogue','Breathe Easy Tincture');
call insert_property('Immune Stimulant','Breathe Easy Tincture');
call insert_property('Immunomodulant','Breathe Easy Tincture');
call insert_property('Sialagogue','Breathe Easy Tincture');
call insert_property('Diuretic','Breathe Easy Tincture');
call insert_property('Emollient','Breathe Easy Tincture');
call insert_property('Antitussive','Breathe Easy Tincture');
call insert_property('Antimicrobial','Breathe Easy Tincture');
call insert_property('Astringent','Breathe Easy Tincture');
call insert_property('Anti-catarrhal','Breathe Easy Tincture');
call insert_property('Hepatorestorative','Spring SnEase Tincture');
call insert_property('Hepatoprotective','Spring SnEase Tincture');
call insert_property('Cholagogue','Spring SnEase Tincture');
call insert_property('Galactogogue','Spring SnEase Tincture');
call insert_property('Demulcent','Spring SnEase Tincture');
call insert_property('Antioxidant','Spring SnEase Tincture');
call insert_property('Anti-inflammatory','Spring SnEase Tincture');
call insert_property('Antidepressant','Spring SnEase Tincture');
call insert_property('Appetite stimulant','Spring SnEase Tincture');
call insert_property('Astringent','Spring SnEase Tincture');
call insert_property('Laxative','Spring SnEase Tincture');
call insert_property('Diaphoretic','Spring SnEase Tincture');
call insert_property('Digestive','Spring SnEase Tincture');
call insert_property('Diuretic','Spring SnEase Tincture');
call insert_property('Emetic','Spring SnEase Tincture');
call insert_property('Emmenagogue','Spring SnEase Tincture');
call insert_property('Stomachic','Spring SnEase Tincture');
call insert_property('Kidney tonic','Spring SnEase Tincture');
call insert_property('Probiotic','Spring SnEase Tincture');
call insert_property('Nervous system relaxant','Spring SnEase Tincture');
call insert_property('Tonic','Spring SnEase Tincture');
call insert_property('Antivirals','Spring SnEase Tincture');
call insert_property('Analgesic','Spring SnEase Tincture');
call insert_property('Immune Stimulant','Spring SnEase Tincture');
call insert_property('Alterative','Spring SnEase Tincture');
call insert_property('Antihistamine','Spring SnEase Tincture');
call insert_property('Hemostatic','Spring SnEase Tincture');
call insert_property('Nutritive','Spring SnEase Tincture');
call insert_property('Rubefacient','Spring SnEase Tincture');
call insert_property('Antioxidant','Spring SnEase Tincture');
call insert_property('Hypocholesterolemic','Spring SnEase Tincture');
call insert_property('Hepatic','Spring SnEase Tincture');
call insert_property('Immunomodulant','Spring SnEase Tincture');
call insert_property('Anti-emetic','Spring SnEase Tincture');
call insert_property('Carminative','Spring SnEase Tincture');
call insert_property('Antispasmodic','Spring SnEase Tincture');
call insert_property('Circulatory Stimulant','Spring SnEase Tincture');
call insert_property('Radioprotective','Spring SnEase Tincture');
call insert_property('Analgesic','Head Aid Tincture');
call insert_property('Anti-inflammatory','Head Aid Tincture');
call insert_property('Anti-rheumatic','Head Aid Tincture');
call insert_property('Antipyretic','Head Aid Tincture');
call insert_property('Astringent','Head Aid Tincture');
call insert_property('Febrifuge','Head Aid Tincture');
call insert_property('Antiseptic','Head Aid Tincture');
call insert_property('Antioxidant','Head Aid Tincture');
call insert_property('Immunosupportive','Head Aid Tincture');
call insert_property('Antispasmodic','Head Aid Tincture');
call insert_property('Aperient','Head Aid Tincture');
call insert_property('Bitter','Head Aid Tincture');
call insert_property('Carminative','Head Aid Tincture');
call insert_property('Diaphoretic','Head Aid Tincture');
call insert_property('Emmenagogue','Head Aid Tincture');
call insert_property('Nervine','Head Aid Tincture');
call insert_property('Sedative','Head Aid Tincture');
call insert_property('Stimulant','Head Aid Tincture');
call insert_property('Stomachic','Head Aid Tincture');
call insert_property('Tonic','Head Aid Tincture');
call insert_property('Antidepressant','Head Aid Tincture');
call insert_property('Antimicrobial','Head Aid Tincture');
call insert_property('Antiviral','Head Aid Tincture');
call insert_property('Anxiolytic','Head Aid Tincture');
call insert_property('Radioprotective','Head Aid Tincture');
call insert_property('Trophorestorative','Head Aid Tincture');
call insert_property('Soporific','Head Aid Tincture');
call insert_property('Anxiolytic','Head Aid Tincture');
call insert_property('Analgesic','Head Aid Tincture');
call insert_property('Hypotensive','Head Aid Tincture');
call insert_property('Relaxant','Head Aid Tincture');
call insert_property('Diuretic','Dandy Bitters');
call insert_property('Cholagogue','Dandy Bitters');
call insert_property('Bitter','Dandy Bitters');
call insert_property('Tonic','Dandy Bitters');
call insert_property('Hepatic','Dandy Bitters');
call insert_property('Alterative','Dandy Bitters');
call insert_property('Aperient','Dandy Bitters');
call insert_property('Nutritive','Dandy Bitters');
call insert_property('Nervine','Dandy Bitters');
call insert_property('Sedative','Dandy Bitters');
call insert_property('Vulnerary','Dandy Bitters');
call insert_property('Carminative','Dandy Bitters');
call insert_property('Antispasmodic','Dandy Bitters');
call insert_property('Galactogogue','Dandy Bitters');
call insert_property('Anti-inflammatory','Dandy Bitters');
call insert_property('Anxiolytic','Dandy Bitters');
call insert_property('Expectorant','Dandy Bitters');
call insert_property('Emmenagogue','Dandy Bitters');
call insert_property('Parasiticide','Dandy Bitters');

-- END PROPERTIES

-- START Traits

call insert_trait('cooling','Ground Down Tincture');
call insert_trait('drying','Ground Down Tincture');
call insert_trait('warming','Ground Down Tincture');
call insert_trait('moistening','Ground Down Tincture');
call insert_trait('sweet','Ground Down Tincture');
call insert_trait('cooling','Tummy Tamer Tincture');
call insert_trait('drying','Tummy Tamer Tincture');
call insert_trait('warming','Tummy Tamer Tincture');
call insert_trait('cooling','Dream Land Tincture');
call insert_trait('drying','Dream Land Tincture');
call insert_trait('warming','Dream Land Tincture');
call insert_trait('moistening','Breathe Easy Tincture');
call insert_trait('cooling','Breathe Easy Tincture');
call insert_trait('drying','Breathe Easy Tincture');
call insert_trait('grounding','Breathe Easy Tincture');
call insert_trait('sweet','Breathe Easy Tincture');
call insert_trait('warming','Breathe Easy Tincture');
call insert_trait('cooling','Spring SnEase Tincture');
call insert_trait('drying','Spring SnEase Tincture');
call insert_trait('warming','Spring SnEase Tincture');
call insert_trait('pungent','Spring SnEase Tincture');
call insert_trait('cooling','Head Aid Tincture');
call insert_trait('drying','Head Aid Tincture');
call insert_trait('cooling','Dandy Bitters');
call insert_trait('drying','Dandy Bitters');

--END Traits