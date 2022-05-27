INSERT INTO public.products(
    name,
    description,
    disclaimer,
    image_path,
    ingredients,
    instructions,
    measurement_size,
    measurement_unit,
    price,
    stock_quantity,
    use_cases,
    created_by,
    created_on,
    updated_by,
    updated_on
)
VALUES
('Ground Down Tincture', 'Our Ground Down tincture was designed with your stress in mind. During those moments of feeling wound up, overworked, anxious, or burnt out, our blend was designed to help ground you back down to Mother Earth. Ground Down includes a blend of nervines such as skullcap, oatstraw, and lavender, mixed with powerful adapogens like ashwagandha and tulsi. Together, these herbs can help you feel unstuck, calm your nerves and settle you back.', 'Do not consume if you are pregnant, have celiac disease or gluten-free, or taking any sedative medications. *These statements have not been evaluated by the Food and Drug Administration. These products are not intended to diagnose, treat, cure, or prevent any diseases.', 'ground-down.jpg', 'Tulsi (Ocimum tenuiflorum), Ashwagandha (Withania somnifera), Lavender (Lavandula spp.), Oatstraw (Avena sativa), Skullcap (Scutellaria lateriflora) Mixed with grain alcohol', 'Take dropper-full as needed up to 3 times per day. Add directly onto or under your tongue, into your tea or coffee, in your smoothie or juice whenever you''re feeling anxious or stressed. We honor that you know your body and needs, please follow a dosage or routine that resonates best for you.', 1, 'OZ', 19, 15, 'May help to uplift mood & energy, and relieve exhaustion. May help with relieve feelings of anxiety and stress. May aid in overcoming chronic stress. May ground and bring you into bodily presence', 'API', CURRENT_DATE, 'API', CURRENT_DATE),
('Tummy Tamer Tincture', '', '', 'tummy-tamer.jpg', 'Peppermint (Mentha × piperita), Ginger root (Zingiber officinale), Fennel seed (Foeniculum vulgare), Senna (Senna alexandrina), grain alcohol', 'Take dropper-full as needed after a meal or before bed. Add directly onto or under your tongue, into your tea or coffee, in your smoothie or juice whenever your digestive system needs a little assist. We honor that you know your body and needs, please follow a dosage or routine that resonates best for you.', 10, 'OZ', 19, 15, '', 'API', CURRENT_DATE, 'API', CURRENT_DATE),
('Dream Land Tincture', '', '', 'dream-land.jpg', 'Valerian (Valeriana officinalis), Chamomile (Matricaria chamomilla), Catnip (Nepeta cataria), Lemon Balm (Melissa officinalis), grain alcohol', '', 10, 'OZ', 19, 6, '', 'API', CURRENT_DATE, 'API', CURRENT_DATE),
('Breathe Easy Tincture', '', '', 'breathe-easy.jpg', 'Licorice root (Glycyrrhiza glabra), Cinnamon (Cinnamomum cassia), Echinacea root (Echinacea angustifolia), Marshmallow root (Althaea officinalis), Elecampane root (Inula helenium), Ginger root (Zingiber officinale), grain alcohol', '', 10, 'OZ', 19, 9, '', 'API', CURRENT_DATE, 'API', CURRENT_DATE),
('Spring Snease Tincture', '', '', 'spring-snease.jpg', 'Elder flower (Sambucus nigra L. ssp. canadensis), Nettle leaf (Urtica dioica), Ginger root (Zingiber officianle), Reishi Mushroom (Ganoderma lucidum), Milk Thistle (Silybum marianum), grain alcohol', '', 10, 'OZ', 19, 15, '', 'API', CURRENT_DATE, 'API', CURRENT_DATE),
('Head Aid Tincture', '', '', 'head-aid.jpg', 'Willow bark (Salix alba), Lemon Balm (Melissa officinalis), Catnip (Nepeta cataria), California Poppy (Eschscholzia californica), Skullcap (Scutellaria lateriflora), grain alcohol', '', 10, 'OZ', 19, 11, '', 'API', CURRENT_DATE, 'API', CURRENT_DATE),
('Dandy Bitters', '', '', 'dandy-bitters.jpg', 'Dandelion root (Taraxacum officinale), Chamomile (Matricaria chamomilla), Fennel seed (Foeniculum vulgare), Orange peel (Citrus sinensis), grain alcohol', '', 10, 'OZ', 17.50, 2, '', 'API', CURRENT_DATE, 'API', CURRENT_DATE);