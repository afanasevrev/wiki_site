--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3
-- Dumped by pg_dump version 16.3

-- Started on 2025-02-25 18:33:53

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4796 (class 0 OID 32874)
-- Dependencies: 220
-- Data for Name: comments; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.comments VALUES (8, 3, 5, 'new');


--
-- TOC entry 4794 (class 0 OID 32859)
-- Dependencies: 218
-- Data for Name: publications; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.publications VALUES (3, 'туц', 'ьуцрере111', 4);
INSERT INTO public.publications VALUES (5, 'vxcvcyrtytrytry', 'cxvxcvbnnbv', 2);


--
-- TOC entry 4792 (class 0 OID 32816)
-- Dependencies: 216
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users VALUES (2, '888@mil.ru', '888', '888', '888', '888', '88888888888', '122765765', 0);
INSERT INTO public.users VALUES (7, '999@mil.ru', '99999', '999999999', NULL, '999', '58858858585', '999', 0);
INSERT INTO public.users VALUES (1, 'uyuyuuy111@mil.ru', '123', '123', '123', '123', '89888888888', NULL, 0);
INSERT INTO public.users VALUES (6, '5858wow@mail.ru', '5858', '5858', NULL, '5858', '58888888888', '5858', 1);
INSERT INTO public.users VALUES (8, 'new@mil.ru', 'new', 'new', NULL, 'new', '75652154232', 'new', 0);


--
-- TOC entry 4802 (class 0 OID 0)
-- Dependencies: 219
-- Name: comments_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.comments_id_seq', 10, true);


--
-- TOC entry 4803 (class 0 OID 0)
-- Dependencies: 217
-- Name: publications_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.publications_id_seq', 8, true);


--
-- TOC entry 4804 (class 0 OID 0)
-- Dependencies: 215
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 8, true);


-- Completed on 2025-02-25 18:33:53

--
-- PostgreSQL database dump complete
--

