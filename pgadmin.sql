drop table spot_topo;
drop table comment;
drop table route;
drop table spot;
drop table booking;
drop table topo;
drop table member;
drop table country;

CREATE TABLE public.booking (
    id integer NOT NULL,
    bookingdate timestamp without time zone NOT NULL,
    plannedreturndate timestamp without time zone NOT NULL,
    returndate timestamp without time zone,
    booker_id integer,
    topo_id integer
);


--
-- TOC entry 196 (class 1259 OID 57987)
-- Name: booking_id_seq; Type: SEQUENCE; Schema: public; Owner: ocp
--

CREATE SEQUENCE public.booking_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2891 (class 0 OID 0)
-- Dependencies: 196
-- Name: booking_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: ocp
--

ALTER SEQUENCE public.booking_id_seq OWNED BY public.booking.id;


--
-- TOC entry 199 (class 1259 OID 57997)
-- Name: comment; Type: TABLE; Schema: public; Owner: ocp
--

CREATE TABLE public.comment (
    id integer NOT NULL,
    date timestamp without time zone NOT NULL,
    text character varying(100) NOT NULL,
    membercomment_id integer NOT NULL,
    route_id integer,
    spot_id integer
);


--
-- TOC entry 198 (class 1259 OID 57995)
-- Name: comment_id_seq; Type: SEQUENCE; Schema: public; Owner: ocp
--

CREATE SEQUENCE public.comment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2892 (class 0 OID 0)
-- Dependencies: 198
-- Name: comment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: ocp
--

ALTER SEQUENCE public.comment_id_seq OWNED BY public.comment.id;


--
-- TOC entry 201 (class 1259 OID 58005)
-- Name: country; Type: TABLE; Schema: public; Owner: ocp
--

CREATE TABLE public.country (
    id integer NOT NULL,
    continent character varying(50) NOT NULL,
    name character varying(100) NOT NULL
);


--
-- TOC entry 200 (class 1259 OID 58003)
-- Name: country_id_seq; Type: SEQUENCE; Schema: public; Owner: ocp
--

CREATE SEQUENCE public.country_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2893 (class 0 OID 0)
-- Dependencies: 200
-- Name: country_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: ocp
--

ALTER SEQUENCE public.country_id_seq OWNED BY public.country.id;


--
-- TOC entry 203 (class 1259 OID 58013)
-- Name: member; Type: TABLE; Schema: public; Owner: ocp
--

CREATE TABLE public.member (
    id integer NOT NULL,
    active boolean NOT NULL,
    datelastconnect timestamp without time zone,
    datejoin timestamp without time zone NOT NULL,
    description character varying(255),
    email character varying(255) NOT NULL,
    login character varying(20) NOT NULL,
    login2 character varying(255) NOT NULL,
    password character varying(100) NOT NULL,
    role character varying(255) NOT NULL
);


--
-- TOC entry 202 (class 1259 OID 58011)
-- Name: member_id_seq; Type: SEQUENCE; Schema: public; Owner: ocp
--

CREATE SEQUENCE public.member_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2894 (class 0 OID 0)
-- Dependencies: 202
-- Name: member_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: ocp
--

ALTER SEQUENCE public.member_id_seq OWNED BY public.member.id;


--
-- TOC entry 205 (class 1259 OID 58024)
-- Name: route; Type: TABLE; Schema: public; Owner: ocp
--

CREATE TABLE public.route (
    id integer NOT NULL,
    description character varying(250) NOT NULL,
    grade integer NOT NULL,
    height integer NOT NULL,
    name character varying(50) NOT NULL,
    memberroute_id integer NOT NULL,
    spot_id integer NOT NULL
);


--
-- TOC entry 204 (class 1259 OID 58022)
-- Name: route_id_seq; Type: SEQUENCE; Schema: public; Owner: ocp
--

CREATE SEQUENCE public.route_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2895 (class 0 OID 0)
-- Dependencies: 204
-- Name: route_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: ocp
--

ALTER SEQUENCE public.route_id_seq OWNED BY public.route.id;


--
-- TOC entry 207 (class 1259 OID 58032)
-- Name: spot; Type: TABLE; Schema: public; Owner: ocp
--

CREATE TABLE public.spot (
    id integer NOT NULL,
    city character varying(50) NOT NULL,
    description character varying(250) NOT NULL,
    latitude double precision NOT NULL,
    longitude double precision NOT NULL,
    name character varying(50) NOT NULL,
    rateless integer NOT NULL,
    ratemore integer NOT NULL,
    type character varying(20) NOT NULL,
    country_id integer NOT NULL,
    memberspot_id integer NOT NULL
);


--
-- TOC entry 206 (class 1259 OID 58030)
-- Name: spot_id_seq; Type: SEQUENCE; Schema: public; Owner: ocp
--

CREATE SEQUENCE public.spot_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2896 (class 0 OID 0)
-- Dependencies: 206
-- Name: spot_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: ocp
--

ALTER SEQUENCE public.spot_id_seq OWNED BY public.spot.id;


--
-- TOC entry 208 (class 1259 OID 58038)
-- Name: spot_topo; Type: TABLE; Schema: public; Owner: ocp
--

CREATE TABLE public.spot_topo (
    spots_id integer NOT NULL,
    topos_id integer NOT NULL
);


--
-- TOC entry 210 (class 1259 OID 58043)
-- Name: topo; Type: TABLE; Schema: public; Owner: ocp
--

CREATE TABLE public.topo (
    id integer NOT NULL,
    author character varying(50) NOT NULL,
    available boolean NOT NULL,
    description character varying(350) NOT NULL,
    edition character varying(50) NOT NULL,
    keywords character varying(350) NOT NULL,
    name character varying(50) NOT NULL,
    publishedyear integer NOT NULL,
    country_id integer NOT NULL,
    owner_id integer NOT NULL
);


--
-- TOC entry 209 (class 1259 OID 58041)
-- Name: topo_id_seq; Type: SEQUENCE; Schema: public; Owner: ocp
--

CREATE SEQUENCE public.topo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2897 (class 0 OID 0)
-- Dependencies: 209
-- Name: topo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: ocp
--

ALTER SEQUENCE public.topo_id_seq OWNED BY public.topo.id;


--
-- TOC entry 2712 (class 2604 OID 57992)
-- Name: booking id; Type: DEFAULT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.booking ALTER COLUMN id SET DEFAULT nextval('public.booking_id_seq'::regclass);


--
-- TOC entry 2713 (class 2604 OID 58000)
-- Name: comment id; Type: DEFAULT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.comment ALTER COLUMN id SET DEFAULT nextval('public.comment_id_seq'::regclass);


--
-- TOC entry 2714 (class 2604 OID 58008)
-- Name: country id; Type: DEFAULT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.country ALTER COLUMN id SET DEFAULT nextval('public.country_id_seq'::regclass);


--
-- TOC entry 2715 (class 2604 OID 58016)
-- Name: member id; Type: DEFAULT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.member ALTER COLUMN id SET DEFAULT nextval('public.member_id_seq'::regclass);


--
-- TOC entry 2716 (class 2604 OID 58027)
-- Name: route id; Type: DEFAULT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.route ALTER COLUMN id SET DEFAULT nextval('public.route_id_seq'::regclass);


--
-- TOC entry 2717 (class 2604 OID 58035)
-- Name: spot id; Type: DEFAULT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.spot ALTER COLUMN id SET DEFAULT nextval('public.spot_id_seq'::regclass);


--
-- TOC entry 2718 (class 2604 OID 58046)
-- Name: topo id; Type: DEFAULT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.topo ALTER COLUMN id SET DEFAULT nextval('public.topo_id_seq'::regclass);


--
-- TOC entry 2868 (class 0 OID 57989)
-- Dependencies: 197
-- Data for Name: booking; Type: TABLE DATA; Schema: public; Owner: ocp
--



--
-- TOC entry 2870 (class 0 OID 57997)
-- Dependencies: 199
-- Data for Name: comment; Type: TABLE DATA; Schema: public; Owner: ocp
--

INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (1, '2018-12-08 15:24:06.548', 'genial', 1, NULL, 2);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (2, '2018-11-27 00:00:00', 'soft', 5, 84, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (3, '2018-07-21 00:00:00', 'super', 3, 35, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (4, '2018-08-07 00:00:00', 'soft', 1, 8, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (5, '2018-09-16 00:00:00', 'hard', 2, 68, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (6, '2018-07-10 00:00:00', 'difficult', 2, 91, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (7, '2018-01-19 00:00:00', 'top', 5, 29, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (8, '2018-05-27 00:00:00', 'wow', 5, 8, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (9, '2018-05-30 00:00:00', 'wow', 1, 8, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (10, '2017-12-28 00:00:00', 'soft', 1, 90, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (11, '2018-11-10 00:00:00', 'never seen better', 4, 58, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (12, '2018-02-26 00:00:00', 'magic', 3, 4, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (13, '2018-03-29 00:00:00', 'top', 5, 6, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (14, '2018-04-05 00:00:00', 'joli', 3, 74, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (15, '2018-10-22 00:00:00', 'difficult', 5, 45, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (16, '2018-02-13 00:00:00', 'never seen better', 5, 70, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (17, '2018-08-20 00:00:00', 'magic', 4, 54, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (18, '2017-12-23 00:00:00', 'super', 4, 34, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (19, '2018-06-11 00:00:00', 'joli', 5, 58, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (20, '2018-10-14 00:00:00', 'wow', 5, 27, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (21, '2018-07-27 00:00:00', 'soft', 4, 70, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (22, '2018-01-04 00:00:00', 'magic', 4, 52, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (23, '2018-10-28 00:00:00', 'hard', 5, 68, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (24, '2018-01-24 00:00:00', 'super', 4, 67, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (25, '2018-09-30 00:00:00', 'super', 3, 91, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (26, '2018-06-09 00:00:00', 'top', 1, 34, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (27, '2018-10-20 00:00:00', 'super', 3, 51, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (28, '2018-08-26 00:00:00', 'joli', 1, 35, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (29, '2018-06-03 00:00:00', 'wow', 2, 63, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (30, '2018-06-20 00:00:00', 'sad', 5, 35, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (31, '2017-12-21 00:00:00', 'easy', 2, 74, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (32, '2018-04-06 00:00:00', 'easy', 4, 90, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (33, '2018-02-25 00:00:00', 'difficult', 1, 29, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (34, '2018-08-12 00:00:00', 'magic', 1, 80, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (35, '2018-07-06 00:00:00', 'never seen better', 1, 90, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (36, '2018-02-16 00:00:00', 'hard', 1, 54, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (37, '2017-12-16 00:00:00', 'never seen better', 5, 34, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (38, '2018-11-05 00:00:00', 'top', 4, 74, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (39, '2018-10-08 00:00:00', 'difficult', 5, 8, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (40, '2018-11-14 00:00:00', 'easy', 2, 67, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (41, '2018-04-21 00:00:00', 'super', 2, 52, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (42, '2018-06-08 00:00:00', 'sad', 5, 90, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (43, '2018-04-25 00:00:00', 'soft', 1, 45, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (44, '2018-01-10 00:00:00', 'magic', 3, 71, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (45, '2018-03-28 00:00:00', 'easy', 2, 70, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (46, '2018-01-13 00:00:00', 'easy', 5, 86, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (47, '2017-12-25 00:00:00', 'easy', 2, 84, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (48, '2018-02-05 00:00:00', 'never seen better', 5, 54, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (49, '2018-09-30 00:00:00', 'hard', 5, 35, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (50, '2018-10-19 00:00:00', 'sad', 2, 80, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (51, '2018-02-28 00:00:00', 'joli', 3, 87, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (52, '2018-03-29 00:00:00', 'joli', 4, 70, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (53, '2018-04-29 00:00:00', 'soft', 3, 35, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (54, '2018-10-29 00:00:00', 'difficult', 2, 8, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (55, '2018-10-30 00:00:00', 'hard', 1, 68, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (56, '2018-08-05 00:00:00', 'easy', 5, 52, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (57, '2018-01-24 00:00:00', 'easy', 2, 4, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (58, '2018-06-14 00:00:00', 'super', 1, 91, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (59, '2018-05-11 00:00:00', 'wow', 4, 71, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (60, '2018-08-08 00:00:00', 'never seen better', 2, 71, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (61, '2018-08-22 00:00:00', 'difficult', 3, 55, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (62, '2018-01-17 00:00:00', 'difficult', 5, 10, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (63, '2018-02-15 00:00:00', 'never seen better', 3, 4, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (64, '2018-01-02 00:00:00', 'hard', 4, 91, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (65, '2018-04-29 00:00:00', 'joli', 5, 58, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (66, '2018-08-29 00:00:00', 'joli', 4, 29, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (67, '2018-06-15 00:00:00', 'joli', 5, 70, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (68, '2018-07-15 00:00:00', 'top', 2, 71, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (69, '2018-10-22 00:00:00', 'wow', 3, 80, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (70, '2018-03-17 00:00:00', 'magic', 2, 56, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (71, '2017-12-13 00:00:00', 'soft', 2, 8, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (72, '2018-05-21 00:00:00', 'never seen better', 2, 55, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (73, '2018-07-21 00:00:00', 'difficult', 3, 54, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (74, '2018-06-22 00:00:00', 'never seen better', 4, 70, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (75, '2018-10-08 00:00:00', 'magic', 2, 34, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (76, '2018-06-11 00:00:00', 'super', 2, 52, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (77, '2018-07-25 00:00:00', 'never seen better', 4, 6, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (78, '2018-08-28 00:00:00', 'sad', 2, 56, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (79, '2018-08-04 00:00:00', 'magic', 2, 45, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (80, '2018-02-21 00:00:00', 'easy', 5, 83, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (81, '2018-11-02 00:00:00', 'easy', 2, 71, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (82, '2018-06-20 00:00:00', 'soft', 4, 70, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (83, '2018-11-27 00:00:00', 'super', 4, 68, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (84, '2018-03-04 00:00:00', 'difficult', 4, 70, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (85, '2018-02-19 00:00:00', 'sad', 4, 6, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (86, '2018-11-21 00:00:00', 'top', 1, 86, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (87, '2018-05-13 00:00:00', 'sad', 5, 58, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (88, '2018-08-30 00:00:00', 'top', 3, 87, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (89, '2018-05-03 00:00:00', 'never seen better', 3, 4, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (90, '2018-10-06 00:00:00', 'soft', 1, 23, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (91, '2018-02-18 00:00:00', 'super', 4, 27, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (92, '2018-03-28 00:00:00', 'never seen better', 4, 10, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (93, '2018-10-29 00:00:00', 'top', 3, 83, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (94, '2018-11-16 00:00:00', 'difficult', 4, 67, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (95, '2018-08-31 00:00:00', 'wow', 2, 74, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (96, '2018-06-24 00:00:00', 'super', 1, 23, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (97, '2018-04-30 00:00:00', 'wow', 1, 83, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (98, '2018-06-15 00:00:00', 'wow', 2, 55, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (99, '2018-07-19 00:00:00', 'top', 5, 83, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (100, '2018-09-15 00:00:00', 'magic', 2, 63, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (101, '2018-08-30 00:00:00', 'difficult', 1, 83, NULL);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (102, '2018-09-29 00:00:00', 'difficult', 3, NULL, 96);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (103, '2018-10-24 00:00:00', 'joli', 3, NULL, 96);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (104, '2018-11-07 00:00:00', 'difficult', 3, NULL, 23);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (105, '2018-11-24 00:00:00', 'difficult', 4, NULL, 87);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (106, '2018-02-22 00:00:00', 'easy', 4, NULL, 71);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (107, '2017-12-12 00:00:00', 'never seen better', 4, NULL, 84);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (108, '2018-01-10 00:00:00', 'easy', 5, NULL, 39);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (109, '2018-11-07 00:00:00', 'never seen better', 1, NULL, 93);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (110, '2017-12-25 00:00:00', 'joli', 1, NULL, 70);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (111, '2018-03-08 00:00:00', 'top', 2, NULL, 56);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (112, '2018-06-23 00:00:00', 'wow', 2, NULL, 96);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (113, '2018-09-06 00:00:00', 'difficult', 5, NULL, 63);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (114, '2018-01-29 00:00:00', 'soft', 3, NULL, 54);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (115, '2018-05-17 00:00:00', 'top', 1, NULL, 36);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (116, '2018-07-07 00:00:00', 'sad', 1, NULL, 90);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (117, '2018-04-07 00:00:00', 'hard', 5, NULL, 55);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (118, '2018-10-18 00:00:00', 'never seen better', 5, NULL, 69);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (119, '2018-06-19 00:00:00', 'hard', 4, NULL, 92);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (120, '2018-04-18 00:00:00', 'soft', 2, NULL, 39);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (121, '2018-01-17 00:00:00', 'super', 5, NULL, 67);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (122, '2018-08-24 00:00:00', 'super', 5, NULL, 6);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (123, '2018-03-18 00:00:00', 'difficult', 3, NULL, 67);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (124, '2018-01-22 00:00:00', 'wow', 3, NULL, 89);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (125, '2018-02-27 00:00:00', 'super', 5, NULL, 4);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (126, '2018-06-22 00:00:00', 'hard', 4, NULL, 4);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (127, '2018-05-15 00:00:00', 'difficult', 1, NULL, 84);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (128, '2018-03-14 00:00:00', 'hard', 4, NULL, 92);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (129, '2018-06-09 00:00:00', 'soft', 3, NULL, 70);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (130, '2017-12-25 00:00:00', 'hard', 5, NULL, 92);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (131, '2018-06-18 00:00:00', 'sad', 1, NULL, 68);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (132, '2018-07-27 00:00:00', 'soft', 1, NULL, 34);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (133, '2017-12-09 00:00:00', 'difficult', 4, NULL, 10);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (134, '2018-06-16 00:00:00', 'top', 3, NULL, 6);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (135, '2018-02-16 00:00:00', 'soft', 1, NULL, 39);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (136, '2018-01-09 00:00:00', 'wow', 2, NULL, 8);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (137, '2018-04-14 00:00:00', 'hard', 4, NULL, 27);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (138, '2018-08-21 00:00:00', 'difficult', 3, NULL, 58);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (139, '2018-07-29 00:00:00', 'magic', 5, NULL, 31);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (140, '2018-05-28 00:00:00', 'easy', 1, NULL, 96);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (141, '2017-12-08 00:00:00', 'difficult', 2, NULL, 4);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (142, '2018-09-23 00:00:00', 'difficult', 2, NULL, 87);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (143, '2018-11-21 00:00:00', 'wow', 3, NULL, 36);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (144, '2018-02-26 00:00:00', 'soft', 5, NULL, 52);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (145, '2018-05-06 00:00:00', 'hard', 1, NULL, 39);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (146, '2018-06-25 00:00:00', 'hard', 1, NULL, 96);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (147, '2018-07-26 00:00:00', 'top', 2, NULL, 35);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (148, '2018-02-11 00:00:00', 'soft', 3, NULL, 34);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (149, '2018-07-19 00:00:00', 'magic', 1, NULL, 96);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (150, '2018-03-01 00:00:00', 'top', 5, NULL, 68);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (151, '2018-05-17 00:00:00', 'top', 4, NULL, 91);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (152, '2018-10-11 00:00:00', 'hard', 5, NULL, 56);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (153, '2018-10-03 00:00:00', 'magic', 1, NULL, 31);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (154, '2018-01-22 00:00:00', 'super', 2, NULL, 51);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (155, '2018-08-06 00:00:00', 'easy', 2, NULL, 35);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (156, '2018-02-08 00:00:00', 'joli', 5, NULL, 71);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (157, '2018-09-03 00:00:00', 'joli', 4, NULL, 36);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (158, '2018-03-10 00:00:00', 'soft', 1, NULL, 51);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (159, '2018-03-16 00:00:00', 'never seen better', 2, NULL, 31);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (160, '2018-05-21 00:00:00', 'super', 2, NULL, 71);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (161, '2018-03-30 00:00:00', 'wow', 3, NULL, 56);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (162, '2018-01-20 00:00:00', 'soft', 3, NULL, 90);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (163, '2018-11-04 00:00:00', 'never seen better', 5, NULL, 52);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (164, '2018-08-17 00:00:00', 'sad', 4, NULL, 84);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (165, '2018-01-31 00:00:00', 'soft', 1, NULL, 8);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (166, '2018-08-06 00:00:00', 'easy', 4, NULL, 91);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (167, '2018-07-23 00:00:00', 'never seen better', 1, NULL, 70);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (168, '2018-08-05 00:00:00', 'never seen better', 1, NULL, 35);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (169, '2018-10-24 00:00:00', 'easy', 4, NULL, 58);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (170, '2018-03-21 00:00:00', 'soft', 2, NULL, 36);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (171, '2017-12-13 00:00:00', 'soft', 2, NULL, 67);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (172, '2018-10-23 00:00:00', 'super', 5, NULL, 86);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (173, '2018-12-01 00:00:00', 'super', 5, NULL, 91);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (174, '2018-10-14 00:00:00', 'wow', 5, NULL, 10);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (175, '2018-01-28 00:00:00', 'soft', 2, NULL, 4);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (176, '2018-02-18 00:00:00', 'difficult', 4, NULL, 90);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (177, '2018-02-24 00:00:00', 'difficult', 4, NULL, 29);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (178, '2018-06-17 00:00:00', 'easy', 4, NULL, 69);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (179, '2018-01-22 00:00:00', 'sad', 5, NULL, 67);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (180, '2018-06-03 00:00:00', 'wow', 2, NULL, 63);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (181, '2018-06-02 00:00:00', 'magic', 3, NULL, 6);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (182, '2018-02-13 00:00:00', 'soft', 3, NULL, 96);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (183, '2018-09-03 00:00:00', 'sad', 4, NULL, 60);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (184, '2018-06-18 00:00:00', 'magic', 5, NULL, 63);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (185, '2018-08-13 00:00:00', 'magic', 2, NULL, 23);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (186, '2018-06-29 00:00:00', 'super', 1, NULL, 96);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (187, '2018-09-05 00:00:00', 'sad', 2, NULL, 68);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (188, '2018-11-12 00:00:00', 'sad', 3, NULL, 29);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (189, '2018-09-03 00:00:00', 'wow', 3, NULL, 10);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (190, '2018-06-24 00:00:00', 'wow', 3, NULL, 71);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (191, '2018-10-26 00:00:00', 'easy', 5, NULL, 35);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (192, '2018-06-25 00:00:00', 'difficult', 1, NULL, 68);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (193, '2018-03-17 00:00:00', 'never seen better', 1, NULL, 68);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (194, '2018-02-28 00:00:00', 'sad', 3, NULL, 87);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (195, '2018-10-22 00:00:00', 'soft', 1, NULL, 8);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (196, '2018-05-17 00:00:00', 'super', 4, NULL, 29);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (197, '2018-04-27 00:00:00', 'easy', 5, NULL, 67);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (198, '2018-02-28 00:00:00', 'easy', 3, NULL, 56);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (199, '2018-07-10 00:00:00', 'joli', 1, NULL, 69);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (200, '2018-07-16 00:00:00', 'never seen better', 3, NULL, 92);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (201, '2018-06-22 00:00:00', 'joli', 5, NULL, 58);
INSERT INTO public.comment (id, date, text, membercomment_id, route_id, spot_id) VALUES (202, '2018-12-08 15:39:14.516', 'cool', 1, 101, NULL);


--
-- TOC entry 2872 (class 0 OID 58005)
-- Dependencies: 201
-- Data for Name: country; Type: TABLE DATA; Schema: public; Owner: ocp
--

INSERT INTO public.country (id, continent, name) VALUES (1, 'Africa', 'Algeria');
INSERT INTO public.country (id, continent, name) VALUES (2, 'Africa', 'Angola');
INSERT INTO public.country (id, continent, name) VALUES (3, 'Africa', 'Benin');
INSERT INTO public.country (id, continent, name) VALUES (4, 'Africa', 'Botswana');
INSERT INTO public.country (id, continent, name) VALUES (5, 'Africa', 'Burkina Faso');
INSERT INTO public.country (id, continent, name) VALUES (6, 'Africa', 'Burundi');
INSERT INTO public.country (id, continent, name) VALUES (7, 'Africa', 'Cameroon');
INSERT INTO public.country (id, continent, name) VALUES (8, 'Africa', 'Cape Verde');
INSERT INTO public.country (id, continent, name) VALUES (9, 'Africa', 'Central African Republic');
INSERT INTO public.country (id, continent, name) VALUES (10, 'Africa', 'Chad');
INSERT INTO public.country (id, continent, name) VALUES (11, 'Africa', 'Comoros');
INSERT INTO public.country (id, continent, name) VALUES (12, 'Africa', 'Democratic Republic of the Congo');
INSERT INTO public.country (id, continent, name) VALUES (13, 'Africa', 'Djibouti');
INSERT INTO public.country (id, continent, name) VALUES (14, 'Africa', 'Egypt');
INSERT INTO public.country (id, continent, name) VALUES (15, 'Africa', 'Equatorial Guinea');
INSERT INTO public.country (id, continent, name) VALUES (16, 'Africa', 'Eritrea');
INSERT INTO public.country (id, continent, name) VALUES (17, 'Africa', 'Ethiopia');
INSERT INTO public.country (id, continent, name) VALUES (18, 'Africa', 'Gabon');
INSERT INTO public.country (id, continent, name) VALUES (19, 'Africa', 'Gambia');
INSERT INTO public.country (id, continent, name) VALUES (20, 'Africa', 'Ghana');
INSERT INTO public.country (id, continent, name) VALUES (21, 'Africa', 'Guinea');
INSERT INTO public.country (id, continent, name) VALUES (22, 'Africa', 'Guinea-Bissau');
INSERT INTO public.country (id, continent, name) VALUES (23, 'Africa', 'Ivory Coast');
INSERT INTO public.country (id, continent, name) VALUES (24, 'Africa', 'Kenya');
INSERT INTO public.country (id, continent, name) VALUES (25, 'Africa', 'Lesotho');
INSERT INTO public.country (id, continent, name) VALUES (26, 'Africa', 'Liberia');
INSERT INTO public.country (id, continent, name) VALUES (27, 'Africa', 'Libya');
INSERT INTO public.country (id, continent, name) VALUES (28, 'Africa', 'Madagascar');
INSERT INTO public.country (id, continent, name) VALUES (29, 'Africa', 'Malawi');
INSERT INTO public.country (id, continent, name) VALUES (30, 'Africa', 'Mali');
INSERT INTO public.country (id, continent, name) VALUES (31, 'Africa', 'Mauritania');
INSERT INTO public.country (id, continent, name) VALUES (32, 'Africa', 'Mauritius');
INSERT INTO public.country (id, continent, name) VALUES (33, 'Africa', 'Morocco');
INSERT INTO public.country (id, continent, name) VALUES (34, 'Africa', 'Mozambique');
INSERT INTO public.country (id, continent, name) VALUES (35, 'Africa', 'Namibia');
INSERT INTO public.country (id, continent, name) VALUES (36, 'Africa', 'Niger');
INSERT INTO public.country (id, continent, name) VALUES (37, 'Africa', 'Nigeria');
INSERT INTO public.country (id, continent, name) VALUES (38, 'Africa', 'Republic of the Congo');
INSERT INTO public.country (id, continent, name) VALUES (39, 'Africa', 'Rwanda');
INSERT INTO public.country (id, continent, name) VALUES (40, 'Africa', 'São Tomé and Príncipe');
INSERT INTO public.country (id, continent, name) VALUES (41, 'Africa', 'Senegal');
INSERT INTO public.country (id, continent, name) VALUES (42, 'Africa', 'Seychelles');
INSERT INTO public.country (id, continent, name) VALUES (43, 'Africa', 'Sierra Leone');
INSERT INTO public.country (id, continent, name) VALUES (44, 'Africa', 'Somalia');
INSERT INTO public.country (id, continent, name) VALUES (45, 'Africa', 'South Africa');
INSERT INTO public.country (id, continent, name) VALUES (46, 'Africa', 'South Sudan');
INSERT INTO public.country (id, continent, name) VALUES (47, 'Africa', 'Sudan');
INSERT INTO public.country (id, continent, name) VALUES (48, 'Africa', 'Swaziland');
INSERT INTO public.country (id, continent, name) VALUES (49, 'Africa', 'Tanzania');
INSERT INTO public.country (id, continent, name) VALUES (50, 'Africa', 'Togo');
INSERT INTO public.country (id, continent, name) VALUES (51, 'Africa', 'Tunisia');
INSERT INTO public.country (id, continent, name) VALUES (52, 'Africa', 'Uganda');
INSERT INTO public.country (id, continent, name) VALUES (53, 'Africa', 'Zambia');
INSERT INTO public.country (id, continent, name) VALUES (54, 'Africa', 'Zimbabwe');
INSERT INTO public.country (id, continent, name) VALUES (55, 'Asia', 'Afghanistan');
INSERT INTO public.country (id, continent, name) VALUES (56, 'Asia', 'Armenia');
INSERT INTO public.country (id, continent, name) VALUES (57, 'Asia', 'Azerbaijan');
INSERT INTO public.country (id, continent, name) VALUES (58, 'Asia', 'Bahrain');
INSERT INTO public.country (id, continent, name) VALUES (59, 'Asia', 'Bangladesh');
INSERT INTO public.country (id, continent, name) VALUES (60, 'Asia', 'Bhutan');
INSERT INTO public.country (id, continent, name) VALUES (61, 'Asia', 'Brunei');
INSERT INTO public.country (id, continent, name) VALUES (62, 'Asia', 'Cambodia');
INSERT INTO public.country (id, continent, name) VALUES (63, 'Asia', 'China');
INSERT INTO public.country (id, continent, name) VALUES (64, 'Asia', 'Cyprus');
INSERT INTO public.country (id, continent, name) VALUES (65, 'Asia', 'East Timor (Timor-Leste)');
INSERT INTO public.country (id, continent, name) VALUES (66, 'Asia', 'Georgia');
INSERT INTO public.country (id, continent, name) VALUES (67, 'Asia', 'India');
INSERT INTO public.country (id, continent, name) VALUES (68, 'Asia', 'Indonesia');
INSERT INTO public.country (id, continent, name) VALUES (69, 'Asia', 'Iran');
INSERT INTO public.country (id, continent, name) VALUES (70, 'Asia', 'Iraq');
INSERT INTO public.country (id, continent, name) VALUES (71, 'Asia', 'Israel');
INSERT INTO public.country (id, continent, name) VALUES (72, 'Asia', 'Japan');
INSERT INTO public.country (id, continent, name) VALUES (73, 'Asia', 'Jordan');
INSERT INTO public.country (id, continent, name) VALUES (74, 'Asia', 'Kazakhstan');
INSERT INTO public.country (id, continent, name) VALUES (75, 'Asia', 'Kuwait');
INSERT INTO public.country (id, continent, name) VALUES (76, 'Asia', 'Kyrgyzstan');
INSERT INTO public.country (id, continent, name) VALUES (77, 'Asia', 'Laos');
INSERT INTO public.country (id, continent, name) VALUES (78, 'Asia', 'Lebanon');
INSERT INTO public.country (id, continent, name) VALUES (79, 'Asia', 'Malaysia');
INSERT INTO public.country (id, continent, name) VALUES (80, 'Asia', 'Maldives');
INSERT INTO public.country (id, continent, name) VALUES (81, 'Asia', 'Mongolia');
INSERT INTO public.country (id, continent, name) VALUES (82, 'Asia', 'Myanmar (Burma)');
INSERT INTO public.country (id, continent, name) VALUES (83, 'Asia', 'Nepal');
INSERT INTO public.country (id, continent, name) VALUES (84, 'Asia', 'North Korea');
INSERT INTO public.country (id, continent, name) VALUES (85, 'Asia', 'Oman');
INSERT INTO public.country (id, continent, name) VALUES (86, 'Asia', 'Pakistan');
INSERT INTO public.country (id, continent, name) VALUES (87, 'Asia', 'Philippines');
INSERT INTO public.country (id, continent, name) VALUES (88, 'Asia', 'Qatar');
INSERT INTO public.country (id, continent, name) VALUES (89, 'Asia', 'Russia');
INSERT INTO public.country (id, continent, name) VALUES (90, 'Asia', 'Saudi Arabia');
INSERT INTO public.country (id, continent, name) VALUES (91, 'Asia', 'Singapore');
INSERT INTO public.country (id, continent, name) VALUES (92, 'Asia', 'South Korea');
INSERT INTO public.country (id, continent, name) VALUES (93, 'Asia', 'Sri Lanka');
INSERT INTO public.country (id, continent, name) VALUES (94, 'Asia', 'Syria');
INSERT INTO public.country (id, continent, name) VALUES (95, 'Asia', 'Tajikistan');
INSERT INTO public.country (id, continent, name) VALUES (96, 'Asia', 'Thailand');
INSERT INTO public.country (id, continent, name) VALUES (97, 'Asia', 'Turkey');
INSERT INTO public.country (id, continent, name) VALUES (98, 'Asia', 'Turkmenistan');
INSERT INTO public.country (id, continent, name) VALUES (99, 'Asia', 'United Arab Emirates');
INSERT INTO public.country (id, continent, name) VALUES (100, 'Asia', 'Uzbekistan');
INSERT INTO public.country (id, continent, name) VALUES (101, 'Asia', 'Vietnam');
INSERT INTO public.country (id, continent, name) VALUES (102, 'Asia', 'Yemen');
INSERT INTO public.country (id, continent, name) VALUES (103, 'Oceania', 'Australia');
INSERT INTO public.country (id, continent, name) VALUES (104, 'Oceania', 'New Zealand');
INSERT INTO public.country (id, continent, name) VALUES (105, 'Oceania', 'Papua New Guinea');
INSERT INTO public.country (id, continent, name) VALUES (106, 'Europe', 'Albania');
INSERT INTO public.country (id, continent, name) VALUES (107, 'Europe', 'Andorra');
INSERT INTO public.country (id, continent, name) VALUES (108, 'Europe', 'Austria');
INSERT INTO public.country (id, continent, name) VALUES (109, 'Europe', 'Belarus');
INSERT INTO public.country (id, continent, name) VALUES (110, 'Europe', 'Belgium');
INSERT INTO public.country (id, continent, name) VALUES (111, 'Europe', 'Bosnia and Herzegovina');
INSERT INTO public.country (id, continent, name) VALUES (112, 'Europe', 'Bulgaria');
INSERT INTO public.country (id, continent, name) VALUES (113, 'Europe', 'Croatia');
INSERT INTO public.country (id, continent, name) VALUES (114, 'Europe', 'Czech Republic');
INSERT INTO public.country (id, continent, name) VALUES (115, 'Europe', 'Denmark');
INSERT INTO public.country (id, continent, name) VALUES (116, 'Europe', 'Estonia');
INSERT INTO public.country (id, continent, name) VALUES (117, 'Europe', 'Finland');
INSERT INTO public.country (id, continent, name) VALUES (118, 'Europe', 'France ');
INSERT INTO public.country (id, continent, name) VALUES (119, 'Europe', 'Germany');
INSERT INTO public.country (id, continent, name) VALUES (120, 'Europe', 'Greece');
INSERT INTO public.country (id, continent, name) VALUES (121, 'Europe', 'Hungary');
INSERT INTO public.country (id, continent, name) VALUES (122, 'Europe', 'Iceland');
INSERT INTO public.country (id, continent, name) VALUES (123, 'Europe', 'Ireland');
INSERT INTO public.country (id, continent, name) VALUES (124, 'Europe', 'Italy');
INSERT INTO public.country (id, continent, name) VALUES (125, 'Europe', 'Kosovo*');
INSERT INTO public.country (id, continent, name) VALUES (126, 'Europe', 'Latvia');
INSERT INTO public.country (id, continent, name) VALUES (127, 'Europe', 'Liechtenstein');
INSERT INTO public.country (id, continent, name) VALUES (128, 'Europe', 'Lithuania');
INSERT INTO public.country (id, continent, name) VALUES (129, 'Europe', 'Luxembourg');
INSERT INTO public.country (id, continent, name) VALUES (130, 'Europe', 'Macedonia');
INSERT INTO public.country (id, continent, name) VALUES (131, 'Europe', 'Malta');
INSERT INTO public.country (id, continent, name) VALUES (132, 'Europe', 'Moldova');
INSERT INTO public.country (id, continent, name) VALUES (133, 'Europe', 'Monaco');
INSERT INTO public.country (id, continent, name) VALUES (134, 'Europe', 'Montenegro');
INSERT INTO public.country (id, continent, name) VALUES (135, 'Europe', 'Netherlands ');
INSERT INTO public.country (id, continent, name) VALUES (136, 'Europe', 'Norway');
INSERT INTO public.country (id, continent, name) VALUES (137, 'Europe', 'Poland');
INSERT INTO public.country (id, continent, name) VALUES (138, 'Europe', 'Portugal');
INSERT INTO public.country (id, continent, name) VALUES (139, 'Europe', 'Romania');
INSERT INTO public.country (id, continent, name) VALUES (140, 'Europe', 'San Marino');
INSERT INTO public.country (id, continent, name) VALUES (141, 'Europe', 'Serbia');
INSERT INTO public.country (id, continent, name) VALUES (142, 'Europe', 'Slovakia');
INSERT INTO public.country (id, continent, name) VALUES (143, 'Europe', 'Slovenia');
INSERT INTO public.country (id, continent, name) VALUES (144, 'Europe', 'Spain');
INSERT INTO public.country (id, continent, name) VALUES (145, 'Europe', 'Sweden');
INSERT INTO public.country (id, continent, name) VALUES (146, 'Europe', 'Switzerland');
INSERT INTO public.country (id, continent, name) VALUES (147, 'Europe', 'Ukraine');
INSERT INTO public.country (id, continent, name) VALUES (148, 'Europe', 'United Kingdom');
INSERT INTO public.country (id, continent, name) VALUES (149, 'Europe', 'Vatican City');
INSERT INTO public.country (id, continent, name) VALUES (150, 'North America', 'Antigua and Barbuda');
INSERT INTO public.country (id, continent, name) VALUES (151, 'North America', 'Bahamas');
INSERT INTO public.country (id, continent, name) VALUES (152, 'North America', 'Barbados');
INSERT INTO public.country (id, continent, name) VALUES (153, 'North America', 'Belize');
INSERT INTO public.country (id, continent, name) VALUES (154, 'North America', 'Canada');
INSERT INTO public.country (id, continent, name) VALUES (155, 'North America', 'Costa Rica');
INSERT INTO public.country (id, continent, name) VALUES (156, 'North America', 'Cuba');
INSERT INTO public.country (id, continent, name) VALUES (157, 'North America', 'Dominica');
INSERT INTO public.country (id, continent, name) VALUES (158, 'North America', 'Dominican Republic');
INSERT INTO public.country (id, continent, name) VALUES (159, 'North America', 'El Salvador');
INSERT INTO public.country (id, continent, name) VALUES (160, 'North America', 'Grenada');
INSERT INTO public.country (id, continent, name) VALUES (161, 'North America', 'Guatemala');
INSERT INTO public.country (id, continent, name) VALUES (162, 'North America', 'Haiti');
INSERT INTO public.country (id, continent, name) VALUES (163, 'North America', 'Honduras');
INSERT INTO public.country (id, continent, name) VALUES (164, 'North America', 'Jamaica');
INSERT INTO public.country (id, continent, name) VALUES (165, 'North America', 'Mexico');
INSERT INTO public.country (id, continent, name) VALUES (166, 'North America', 'Nicaragua');
INSERT INTO public.country (id, continent, name) VALUES (167, 'North America', 'Panama');
INSERT INTO public.country (id, continent, name) VALUES (168, 'North America', 'Saint Kitts and Nevis');
INSERT INTO public.country (id, continent, name) VALUES (169, 'North America', 'Saint Lucia');
INSERT INTO public.country (id, continent, name) VALUES (170, 'North America', 'Saint Vincent and the Grenadines');
INSERT INTO public.country (id, continent, name) VALUES (171, 'North America', 'Trinidad and Tobago');
INSERT INTO public.country (id, continent, name) VALUES (172, 'North America', 'United States of America');
INSERT INTO public.country (id, continent, name) VALUES (173, 'South America', 'Argentina');
INSERT INTO public.country (id, continent, name) VALUES (174, 'South America', 'Bolivia');
INSERT INTO public.country (id, continent, name) VALUES (175, 'South America', 'Brazil');
INSERT INTO public.country (id, continent, name) VALUES (176, 'South America', 'Chile');
INSERT INTO public.country (id, continent, name) VALUES (177, 'South America', 'Colombia');
INSERT INTO public.country (id, continent, name) VALUES (178, 'South America', 'Ecuador');
INSERT INTO public.country (id, continent, name) VALUES (179, 'South America', 'Guyana');
INSERT INTO public.country (id, continent, name) VALUES (180, 'South America', 'Paraguay');
INSERT INTO public.country (id, continent, name) VALUES (181, 'South America', 'Peru');
INSERT INTO public.country (id, continent, name) VALUES (182, 'South America', 'Suriname');
INSERT INTO public.country (id, continent, name) VALUES (183, 'South America', 'Uruguay');
INSERT INTO public.country (id, continent, name) VALUES (184, 'South America', 'Venezuela');
INSERT INTO public.country (id, continent, name) VALUES (185, 'Oceania', 'Fiji');
INSERT INTO public.country (id, continent, name) VALUES (186, 'Oceania', 'Kiribati');
INSERT INTO public.country (id, continent, name) VALUES (187, 'Oceania', 'Marshall Islands');
INSERT INTO public.country (id, continent, name) VALUES (188, 'Oceania', 'Federated States of Micronesia');
INSERT INTO public.country (id, continent, name) VALUES (189, 'Oceania', 'Nauru');
INSERT INTO public.country (id, continent, name) VALUES (190, 'Oceania', 'Palau');
INSERT INTO public.country (id, continent, name) VALUES (191, 'Oceania', 'Samoa');
INSERT INTO public.country (id, continent, name) VALUES (192, 'Oceania', 'Solomon Islands');
INSERT INTO public.country (id, continent, name) VALUES (193, 'Oceania', 'Tonga');
INSERT INTO public.country (id, continent, name) VALUES (194, 'Oceania', 'Tuvalu');
INSERT INTO public.country (id, continent, name) VALUES (195, 'Oceania', 'Vanuatu');
INSERT INTO public.country (id, continent, name) VALUES (196, 'Europe', 'Bretagne');


--
-- TOC entry 2874 (class 0 OID 58013)
-- Dependencies: 203
-- Data for Name: member; Type: TABLE DATA; Schema: public; Owner: ocp
--

INSERT INTO public.member (id, active, datelastconnect, datejoin, description, email, login, login2, password, role) VALUES (2, true, NULL, '2018-12-08 15:19:51.13', 'regular guy', 'bob@bob.bob', 'BOB', 'BOB', '$2a$10$C3jPrssqvT4/cPXb8DQ/Juc2cFVERCewMexl2XvsNwT/O5VUB7hAC', 'admin');
INSERT INTO public.member (id, active, datelastconnect, datejoin, description, email, login, login2, password, role) VALUES (3, true, NULL, '2018-12-08 15:21:15.023', 'doyenne', 'r@r.r', 'RAYMONDE', 'RAYMONDE', '$2a$10$IHnBDwx2lzHhr0x7D.IBlOtMGx/u9LcJqJf2wLKHDfKz4A36ZPfLe', 'admin');
INSERT INTO public.member (id, active, datelastconnect, datejoin, description, email, login, login2, password, role) VALUES (4, true, NULL, '2018-12-08 15:22:11.032', 'best alive', 's@s.s', 'SAM', 'SAM', '$2a$10$qzO/m9./C0ZoryF4adjYdOsmWKyiMyU.c8umD7Y6Xu9dq0r5/rpr6', 'admin');
INSERT INTO public.member (id, active, datelastconnect, datejoin, description, email, login, login2, password, role) VALUES (5, true, NULL, '2018-12-08 15:22:47.799', 'smith without wessons', 'ffrfrf@gmail.com', 'JOHN', 'JOHN', '$2a$10$xR5eBa8kAnF4AH05ENx76OMDMNIKw3SA9NCQFl1M.UmvJ7uvqheWy', 'admin');
INSERT INTO public.member (id, active, datelastconnect, datejoin, description, email, login, login2, password, role) VALUES (1, true, '2018-12-08 15:25:11.321', '2018-12-08 15:17:22.994', 'superadmin', 'loki@loki.loki', 'LOKI', 'LOKI', '$2a$10$dJMoIvZu8dF8/e.wadmto.DMVzQIPiXN4/lulOpRqe6Pfb7CYsM12', 'superadmin');


--
-- TOC entry 2876 (class 0 OID 58024)
-- Dependencies: 205
-- Data for Name: route; Type: TABLE DATA; Schema: public; Owner: ocp
--

INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (1, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 2, 20, 'Ut Erat Sed Corporation', 2, 55);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (2, 'Lorem ipsum dolor sit amet, consectetuer', 14, 45, 'Nunc Incorporated', 3, 34);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (3, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed', 13, 29, 'Arcu Company', 5, 55);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (4, 'Lorem ipsum dolor', 5, 41, 'At Lacus Quisque Foundation', 5, 45);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (5, 'Lorem ipsum dolor sit amet, consectetuer', 20, 5, 'Morbi Tristique Limited', 4, 71);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (6, 'Lorem ipsum dolor sit amet, consectetuer', 7, 30, 'Tortor Institute', 3, 84);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (7, 'Lorem', 27, 38, 'Faucibus Ltd', 2, 29);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (8, 'Lorem ipsum', 21, 15, 'Vel Faucibus Id Inc.', 4, 35);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (9, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur', 10, 27, 'Ut LLP', 1, 80);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (10, 'Lorem ipsum dolor sit amet,', 25, 3, 'Congue Consulting', 5, 90);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (11, 'Lorem ipsum', 28, 34, 'Semper Rutrum Fusce Institute', 1, 84);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (12, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur', 11, 29, 'Aliquam Adipiscing Lobortis Foundation', 4, 67);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (13, 'Lorem ipsum dolor sit amet,', 8, 34, 'Class Aptent Taciti Limited', 5, 74);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (14, 'Lorem ipsum dolor sit', 13, 36, 'Iaculis Consulting', 5, 56);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (15, 'Lorem', 14, 14, 'Pede Nunc Industries', 1, 56);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (16, 'Lorem ipsum dolor sit amet, consectetuer', 3, 43, 'Arcu Sed Eu Ltd', 1, 58);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (17, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur', 28, 14, 'Phasellus Institute', 1, 87);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (18, 'Lorem ipsum', 19, 32, 'Cras Dolor Dolor Company', 3, 83);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (19, 'Lorem', 26, 39, 'Auctor Velit Aliquam Ltd', 5, 27);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (20, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 7, 11, 'Donec Fringilla Donec Industries', 3, 96);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (21, 'Lorem ipsum dolor sit amet,', 15, 48, 'Convallis Convallis Dolor Foundation', 4, 54);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (22, 'Lorem ipsum dolor', 8, 30, 'Quisque Ac Ltd', 5, 83);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (23, 'Lorem ipsum dolor', 23, 42, 'Lectus Justo Consulting', 3, 90);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (24, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed', 24, 17, 'Accumsan Institute', 1, 90);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (25, 'Lorem ipsum dolor sit amet,', 20, 46, 'Semper Inc.', 2, 23);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (26, 'Lorem ipsum dolor sit amet, consectetuer', 12, 24, 'Cursus Vestibulum Mauris Foundation', 3, 74);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (27, 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 29, 35, 'Enim Nunc Associates', 5, 74);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (28, 'Lorem ipsum dolor', 18, 5, 'Enim Curabitur Massa Corporation', 5, 51);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (29, 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 19, 37, 'Etiam Company', 3, 52);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (30, 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 11, 2, 'Feugiat Tellus Industries', 1, 10);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (31, 'Lorem ipsum dolor sit amet, consectetuer', 24, 37, 'Tincidunt Neque Vitae Associates', 2, 80);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (32, 'Lorem ipsum dolor sit', 20, 15, 'Phasellus Nulla Integer Associates', 2, 8);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (33, 'Lorem ipsum', 6, 49, 'Lectus Industries', 1, 96);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (34, 'Lorem ipsum dolor sit amet,', 20, 25, 'Suscipit Est Consulting', 2, 34);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (35, 'Lorem ipsum dolor sit amet,', 25, 28, 'Neque Sed Sem Foundation', 2, 4);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (36, 'Lorem ipsum', 3, 16, 'Sem Nulla Institute', 2, 70);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (37, 'Lorem ipsum dolor', 27, 16, 'Etiam Bibendum Corp.', 4, 54);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (38, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur', 30, 30, 'Posuere Enim PC', 1, 55);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (39, 'Lorem ipsum dolor sit', 13, 13, 'Arcu Nunc Associates', 4, 83);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (40, 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 24, 27, 'Purus Mauris LLP', 4, 68);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (41, 'Lorem ipsum dolor sit amet, consectetuer', 27, 23, 'Ipsum Limited', 4, 70);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (42, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur', 18, 8, 'Dolor Incorporated', 1, 96);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (43, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 7, 7, 'Consequat Purus Consulting', 5, 87);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (44, 'Lorem ipsum dolor', 25, 20, 'Mattis Associates', 1, 96);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (45, 'Lorem', 8, 13, 'Sed Dictum Corporation', 5, 87);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (46, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur', 10, 31, 'Vel Sapien Limited', 2, 58);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (47, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed', 11, 44, 'Nisi Mauris Corp.', 1, 51);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (48, 'Lorem ipsum dolor sit amet, consectetuer', 5, 11, 'Dictum Ultricies Ligula Associates', 4, 34);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (49, 'Lorem ipsum dolor sit', 8, 1, 'Facilisis Inc.', 5, 35);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (50, 'Lorem ipsum', 14, 42, 'Ut Molestie In LLP', 2, 74);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (51, 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 13, 19, 'Non Cursus Non LLP', 1, 55);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (52, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 8, 49, 'Duis Ac Consulting', 5, 34);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (53, 'Lorem', 12, 30, 'Ante Ipsum Industries', 2, 91);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (54, 'Lorem', 13, 4, 'Sed Leo Cras Inc.', 1, 52);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (55, 'Lorem ipsum dolor sit', 16, 23, 'Pede Ac Urna Foundation', 3, 23);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (56, 'Lorem ipsum dolor sit amet,', 6, 25, 'Orci Phasellus Dapibus Incorporated', 2, 34);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (57, 'Lorem ipsum dolor sit amet,', 24, 30, 'Rutrum Incorporated', 2, 63);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (58, 'Lorem ipsum dolor sit amet,', 21, 49, 'Risus Morbi Metus Institute', 3, 6);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (59, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 3, 8, 'Elit Institute', 1, 58);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (60, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed', 14, 38, 'In Mi Incorporated', 5, 6);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (61, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur', 27, 7, 'Ut LLP', 3, 45);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (62, 'Lorem ipsum dolor sit amet, consectetuer', 14, 48, 'Velit Cras Lorem LLP', 5, 35);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (63, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur', 3, 3, 'Nibh PC', 3, 91);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (64, 'Lorem ipsum dolor sit amet, consectetuer', 5, 26, 'Dolor Egestas Rhoncus LLC', 2, 55);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (65, 'Lorem ipsum dolor', 29, 18, 'Elit Elit Fermentum Ltd', 4, 55);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (66, 'Lorem', 8, 38, 'Vivamus Industries', 2, 52);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (67, 'Lorem ipsum dolor sit amet,', 30, 25, 'Donec Consulting', 2, 74);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (68, 'Lorem ipsum dolor', 1, 37, 'Proin Eget LLC', 3, 87);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (69, 'Lorem ipsum dolor', 2, 24, 'Diam Limited', 5, 54);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (70, 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 29, 23, 'Volutpat Incorporated', 4, 10);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (71, 'Lorem', 7, 45, 'Enim Limited', 3, 51);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (72, 'Lorem ipsum dolor sit amet,', 8, 27, 'Nisl LLC', 1, 70);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (73, 'Lorem ipsum dolor sit', 6, 33, 'Congue In Corporation', 5, 54);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (74, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed', 18, 37, 'Varius Ultrices Ltd', 3, 74);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (75, 'Lorem ipsum', 14, 22, 'Sed Nec Metus Foundation', 1, 4);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (76, 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 11, 9, 'Nunc Mauris Morbi Institute', 2, 56);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (77, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed', 1, 14, 'Convallis In Cursus Institute', 1, 56);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (78, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 23, 20, 'Rutrum Fusce Ltd', 1, 6);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (79, 'Lorem', 12, 46, 'Auctor Mauris Vel Incorporated', 1, 51);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (80, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed', 2, 22, 'Cum Sociis Natoque PC', 5, 35);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (81, 'Lorem', 26, 35, 'Gravida Foundation', 5, 86);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (82, 'Lorem ipsum dolor sit amet,', 4, 44, 'Quam Institute', 2, 63);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (83, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed', 13, 24, 'Fringilla Est Mauris Limited', 2, 29);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (84, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur', 13, 48, 'Curae; Phasellus LLP', 1, 52);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (85, 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 16, 41, 'Vitae Risus Duis Industries', 2, 84);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (86, 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 20, 25, 'Lacinia Vitae Sodales Associates', 4, 63);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (87, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 19, 3, 'Consequat Dolor Associates', 3, 86);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (88, 'Lorem ipsum dolor sit amet,', 1, 25, 'Nibh Inc.', 1, 68);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (89, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed', 6, 10, 'Ut Nec LLP', 4, 71);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (90, 'Lorem ipsum', 22, 25, 'Dui Semper Limited', 5, 58);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (91, 'Lorem ipsum dolor sit', 26, 13, 'Velit Industries', 4, 54);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (92, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed', 17, 6, 'Phasellus Dapibus Institute', 5, 10);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (93, 'Lorem ipsum', 25, 19, 'Egestas A Inc.', 2, 80);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (94, 'Lorem ipsum dolor sit amet, consectetuer', 24, 17, 'Et Corp.', 2, 80);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (95, 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 17, 13, 'Pretium Neque Ltd', 5, 34);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (96, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed', 10, 4, 'Suspendisse Aliquet Molestie Incorporated', 3, 91);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (97, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 13, 13, 'Aliquam Rutrum Lorem Consulting', 1, 68);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (98, 'Lorem ipsum', 1, 20, 'Ipsum Curabitur Consequat LLP', 3, 23);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (99, 'Lorem', 29, 46, 'Magna Et Ipsum Inc.', 1, 63);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (100, 'Lorem ipsum', 29, 43, 'Aliquet Phasellus Fermentum Foundation', 1, 86);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (101, 'dsdsds', 8, 13, 'TOKAPO', 1, 3);
INSERT INTO public.route (id, description, grade, height, name, memberroute_id, spot_id) VALUES (102, 'quite hard', 21, 19, 'TOPOLOGISTE', 1, 2);


--
-- TOC entry 2878 (class 0 OID 58032)
-- Dependencies: 207
-- Data for Name: spot; Type: TABLE DATA; Schema: public; Owner: ocp
--

INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (3, 'Metairie', 'Lorem ipsum dolor sit amet,', 57.720579999999998, 109.49935000000001, 'C3T 0T8', 0, 0, 'BOULDER', 80, 3);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (4, 'Adrano', 'Lorem ipsum', -87.036649999999995, -159.76191, 'H4M 6Z2', 0, 0, 'ROPECLIMB', 131, 3);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (5, 'Ulhasnagar', 'Lorem ipsum', -57.515459999999997, 50.268279999999997, 'M3P 3O3', 0, 0, 'BOULDER', 153, 2);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (6, 'Montague', 'Lorem', 47.481169999999999, -74.725160000000002, 'L4W 7Z1', 0, 0, 'ROPECLIMB', 133, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (7, 'Porretta Terme', 'Lorem ipsum dolor sit amet,', 6.6202500000000004, -48.244929999999997, 'A8Z 7F0', 0, 0, 'BOULDER', 144, 5);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (8, 'Oberursel', 'Lorem ipsum', 75.714269999999999, -110.03597000000001, 'E0N 0Z2', 0, 0, 'BOULDER', 87, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (9, 'Dudley', 'Lorem ipsum dolor', -74.936729999999997, 23.504950000000001, 'R6I 2Y1', 0, 0, 'BOULDER', 168, 4);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (10, 'Jauche', 'Lorem ipsum dolor', 15.139720000000001, 14.184290000000001, 'F9T 8N8', 0, 0, 'BOULDER', 84, 5);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (11, 'Macduff', 'Lorem', 31.962070000000001, -45.010570000000001, 'J6U 8L4', 0, 0, 'BOULDER', 66, 3);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (12, 'Tailles', 'Lorem', -32.536270000000002, 97.101600000000005, 'R8B 5S1', 0, 0, 'BOULDER', 158, 2);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (13, 'Martello/Martell', 'Lorem ipsum dolor sit amet, consectetuer', 4.8182299999999998, 55.490070000000003, 'H5Z 7A4', 0, 0, 'ROPECLIMB', 160, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (14, 'Boncelles', 'Lorem', 12.440580000000001, 158.10673, 'Y6Y 0K1', 0, 0, 'ROPECLIMB', 30, 5);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (15, 'Laives/Leifers', 'Lorem', -15.15114, -164.13467, 'N2J 9U6', 0, 0, 'ROPECLIMB', 142, 2);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (16, 'Huntsville', 'Lorem ipsum', -7.5643099999999999, -39.985280000000003, 'Z3K 8U8', 0, 0, 'ROPECLIMB', 119, 2);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (17, 'North Saanich', 'Lorem ipsum dolor', -69.449510000000004, 117.26103000000001, 'H6A 0O4', 0, 0, 'BOULDER', 167, 2);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (18, 'Bastia Umbra', 'Lorem ipsum dolor sit amet, consectetuer adipiscing', -11.70077, 167.84976, 'M8L 8L5', 0, 0, 'BOULDER', 117, 4);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (19, 'Arquata del Tronto', 'Lorem ipsum dolor sit', -62.965310000000002, 60.298740000000002, 'Z3E 3T3', 0, 0, 'BOULDER', 142, 4);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (20, 'Alma', 'Lorem ipsum dolor sit amet, consectetuer', 61.977530000000002, 172.89155, 'O4V 5H2', 0, 0, 'ROPECLIMB', 160, 4);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (21, 'Minturno', 'Lorem ipsum dolor', -59.875929999999997, -88.030349999999999, 'J1M 2K1', 0, 0, 'BOULDER', 181, 2);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (22, 'Roccabruna', 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 79.562370000000001, -64.511539999999997, 'H7W 4E2', 0, 0, 'BOULDER', 28, 2);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (23, 'Fresno', 'Lorem ipsum dolor sit amet,', -62.795769999999997, -9.9498700000000007, 'H4L 3N9', 0, 0, 'BOULDER', 152, 5);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (24, 'Westerlo', 'Lorem ipsum dolor sit amet, consectetuer adipiscing', -3.16147, 80.291759999999996, 'F1J 3W2', 0, 0, 'BOULDER', 157, 4);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (25, 'Gjoa Haven', 'Lorem ipsum', 36.115839999999999, 144.41734, 'Q0K 4M9', 0, 0, 'BOULDER', 34, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (26, 'Whyalla', 'Lorem ipsum dolor', 89.122200000000007, -115.17357, 'N1G 8I2', 0, 0, 'BOULDER', 94, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (27, 'Rezzoaglio', 'Lorem ipsum', 85.492990000000006, -83.879189999999994, 'A9C 4F3', 0, 0, 'BOULDER', 178, 5);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (28, 'Noragugume', 'Lorem ipsum', 71.457229999999996, -70.373180000000005, 'Q9Q 1P7', 0, 0, 'BOULDER', 113, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (29, 'Didim', 'Lorem ipsum dolor sit', 42.453600000000002, -50.365220000000001, 'Z2O 3Q8', 0, 0, 'BOULDER', 45, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (30, 'Anápolis', 'Lorem ipsum dolor sit amet,', 55.475619999999999, 4.5406199999999997, 'Q1B 4N4', 0, 0, 'ROPECLIMB', 172, 2);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (31, 'Lombardsijde', 'Lorem ipsum dolor sit amet, consectetuer', 81.148529999999994, 164.53862000000001, 'N3S 9T1', 0, 0, 'BOULDER', 119, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (32, 'Salerno', 'Lorem ipsum dolor sit amet, consectetuer', -13.60547, 86.489500000000007, 'T0P 6Q0', 0, 0, 'BOULDER', 49, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (33, 'Ludwigshafen', 'Lorem ipsum dolor sit amet,', -65.377979999999994, -19.067630000000001, 'S8V 2S7', 0, 0, 'BOULDER', 160, 3);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (34, 'Rutten', 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 8.3273899999999994, -107.72402, 'S0M 2K9', 0, 0, 'ROPECLIMB', 195, 5);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (35, 'Zamora', 'Lorem ipsum dolor sit', -86.649050000000003, 2.2873899999999998, 'C7Y 0K7', 0, 0, 'BOULDER', 61, 2);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (36, 'Nicoya', 'Lorem ipsum dolor sit amet,', -14.08314, 83.155919999999995, 'E2V 2Z3', 0, 0, 'BOULDER', 65, 4);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (37, 'Grimaldi', 'Lorem ipsum dolor sit amet, consectetuer', 14.15531, 80.169589999999999, 'E0B 9R7', 0, 0, 'ROPECLIMB', 3, 5);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (38, 'Surat', 'Lorem ipsum', 35.462350000000001, 127.08264, 'S5S 3I3', 0, 0, 'BOULDER', 97, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (39, 'Thalassery', 'Lorem ipsum', -31.255089999999999, -167.59560999999999, 'G4N 5G1', 0, 0, 'BOULDER', 173, 4);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (40, 'Riksingen', 'Lorem', -54.931559999999998, -30.3566, 'I6Y 5Q6', 0, 0, 'BOULDER', 28, 2);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (41, 'Prince George', 'Lorem', -30.360849999999999, 82.505399999999995, 'S8J 1I5', 0, 0, 'BOULDER', 130, 3);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (42, 'Fontanafredda', 'Lorem', -17.44669, -131.20938000000001, 'O8B 5N2', 0, 0, 'BOULDER', 144, 4);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (43, 'Feltre', 'Lorem ipsum dolor sit amet, consectetuer adipiscing', -41.789940000000001, -138.29821999999999, 'F0J 0O3', 0, 0, 'BOULDER', 49, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (44, 'Katowice', 'Lorem ipsum dolor sit amet,', -31.63541, 60.498899999999999, 'D1E 1B3', 0, 0, 'ROPECLIMB', 96, 3);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (45, 'Woodstock', 'Lorem ipsum dolor sit amet, consectetuer', -27.625979999999998, 90.21499, 'U3E 2L8', 0, 0, 'BOULDER', 91, 4);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (46, 'Oyen', 'Lorem ipsum dolor sit amet, consectetuer', 29.037970000000001, 125.87014000000001, 'I7D 0V8', 0, 0, 'BOULDER', 30, 4);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (47, 'Murdochville', 'Lorem ipsum dolor', 36.62379, -40.262560000000001, 'V4Q 2K3', 0, 0, 'BOULDER', 133, 2);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (48, 'Presles', 'Lorem ipsum dolor sit amet, consectetuer', -1.4116599999999999, -71.134559999999993, 'I1S 3P9', 0, 0, 'BOULDER', 170, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (49, 'Chelmsford', 'Lorem ipsum dolor sit amet,', 8.9362200000000005, -106.59389, 'I3W 5D5', 0, 0, 'BOULDER', 93, 2);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (50, 'Canmore', 'Lorem ipsum dolor', 73.146749999999997, -81.653769999999994, 'L2A 7C3', 0, 0, 'BOULDER', 151, 5);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (51, 'Mosciano Sant''Angelo', 'Lorem ipsum dolor', -48.214680000000001, 42.025750000000002, 'P3F 6P2', 0, 0, 'BOULDER', 171, 5);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (52, 'Landshut', 'Lorem ipsum dolor sit amet, consectetuer', 54.683190000000003, 30.424880000000002, 'P4N 7C1', 0, 0, 'BOULDER', 156, 4);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (53, 'Anantapur', 'Lorem ipsum dolor sit amet,', -29.507210000000001, -108.40506000000001, 'I1B 3I6', 0, 0, 'BOULDER', 28, 2);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (54, 'Argyle', 'Lorem ipsum dolor sit amet, consectetuer adipiscing', -3.7585000000000002, 20.53633, 'Z5I 4V2', 0, 0, 'BOULDER', 44, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (55, 'Henstedt-Ulzburg', 'Lorem ipsum', 84.713350000000005, 28.713830000000002, 'V8F 4A9', 0, 0, 'ROPECLIMB', 116, 5);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (56, 'Cambridge', 'Lorem ipsum dolor', -38.992539999999998, 93.078149999999994, 'C7P 3T2', 0, 0, 'ROPECLIMB', 95, 5);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (57, 'Charters Towers', 'Lorem', 1.7631399999999999, 174.66886, 'Z6G 8K8', 0, 0, 'ROPECLIMB', 33, 2);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (58, 'Mysore', 'Lorem ipsum dolor', -65.531319999999994, -15.10103, 'E2J 3O9', 0, 0, 'ROPECLIMB', 62, 5);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (59, 'North Battleford', 'Lorem ipsum dolor', 7.5551700000000004, -113.62945000000001, 'M1J 7L3', 0, 0, 'BOULDER', 51, 4);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (60, 'Bear', 'Lorem', -0.44786999999999999, 12.76843, 'S9E 5X7', 0, 0, 'ROPECLIMB', 61, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (61, 'Butte', 'Lorem ipsum dolor sit', 20.887730000000001, 144.65054000000001, 'U8Y 2I9', 0, 0, 'BOULDER', 107, 2);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (62, 'Hattem', 'Lorem ipsum dolor', 57.13252, -173.10706999999999, 'Y8J 9E5', 0, 0, 'BOULDER', 101, 4);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (63, 'Santa Croce sull''Arno', 'Lorem ipsum dolor', 63.064, 99.739590000000007, 'P4M 8A6', 0, 0, 'BOULDER', 30, 2);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (64, 'Fort Laird', 'Lorem', -9.4034800000000001, -101.18013999999999, 'T7G 3U1', 0, 0, 'ROPECLIMB', 14, 4);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (65, 'Esen', 'Lorem ipsum dolor', 63.657200000000003, -154.73947999999999, 'E8Q 3L9', 0, 0, 'BOULDER', 115, 3);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (66, 'Orangeville', 'Lorem ipsum dolor sit', -9.9022299999999994, 43.90278, 'C3V 0A0', 0, 0, 'BOULDER', 124, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (67, 'Vanier', 'Lorem ipsum dolor sit', 89.706429999999997, -102.80774, 'H9Q 5B0', 0, 0, 'BOULDER', 60, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (68, 'Tourinnes-Saint-Lambert', 'Lorem ipsum dolor', 77.939459999999997, 0.13933000000000001, 'J5K 2M2', 0, 0, 'BOULDER', 172, 5);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (2, 'Attigliano', 'Lorem ipsum dolor sit amet,', -33.797359999999998, -145.46311, 'J5M 0K3', 0, 0, 'ROPECLIMB', 5, 3);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (69, 'Lublin', 'Lorem ipsum dolor', 81.416370000000001, 103.53310999999999, 'J3S 7J4', 0, 0, 'ROPECLIMB', 61, 3);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (70, 'Precenicco', 'Lorem', 79.421009999999995, 152.22570999999999, 'K1E 1E5', 0, 0, 'ROPECLIMB', 42, 5);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (71, 'Senftenberg', 'Lorem ipsum dolor sit', -50.678609999999999, 29.377960000000002, 'O9G 5E7', 0, 0, 'ROPECLIMB', 7, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (72, 'Rauco', 'Lorem ipsum dolor sit amet, consectetuer', -89.818749999999994, 144.97012000000001, 'K4M 3K3', 0, 0, 'BOULDER', 59, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (73, 'Hoshiarpur', 'Lorem ipsum', 1.1867799999999999, -173.07897, 'M2D 0J0', 0, 0, 'BOULDER', 123, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (74, 'Deerlijk', 'Lorem ipsum dolor sit amet,', -28.464490000000001, -154.73230000000001, 'S0G 2W3', 0, 0, 'ROPECLIMB', 69, 3);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (75, 'Opglabbeek', 'Lorem ipsum dolor sit amet, consectetuer', 57.763170000000002, -100.11105999999999, 'Q2F 8Y5', 0, 0, 'BOULDER', 49, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (76, 'Kaduna', 'Lorem ipsum dolor', 27.273530000000001, 3.91411, 'Y3R 5F3', 0, 0, 'BOULDER', 39, 5);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (77, 'Wolfenbüttel', 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 82.740250000000003, 174.94976, 'M1V 3H8', 0, 0, 'BOULDER', 189, 4);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (78, 'Wemmel', 'Lorem ipsum', -80.551919999999996, 88.960669999999993, 'A9L 1Q6', 0, 0, 'BOULDER', 106, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (79, 'Korba', 'Lorem ipsum', -55.190019999999997, 62.538530000000002, 'U2S 7L5', 0, 0, 'ROPECLIMB', 137, 3);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (80, 'Cerignola', 'Lorem ipsum dolor', -64.173450000000003, 110.19110999999999, 'G8M 0A8', 0, 0, 'BOULDER', 73, 4);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (81, 'Vihari', 'Lorem', -55.752450000000003, 146.61941999999999, 'C8R 5V5', 0, 0, 'BOULDER', 32, 5);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (82, 'Otricoli', 'Lorem ipsum dolor', 21.855840000000001, 31.89302, 'I8Y 4J3', 0, 0, 'BOULDER', 88, 3);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (83, 'Chester', 'Lorem ipsum dolor sit amet, consectetuer', -10.509219999999999, -103.70105, 'C9K 4G6', 0, 0, 'ROPECLIMB', 138, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (84, 'Ponte San Nicolò', 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 22.979489999999998, -32.880629999999996, 'J8K 8D9', 0, 0, 'ROPECLIMB', 184, 2);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (85, 'Eisenstadt', 'Lorem ipsum dolor sit amet, consectetuer', 49.308230000000002, 175.87161, 'D5Y 6X3', 0, 0, 'BOULDER', 45, 2);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (86, 'Torgny', 'Lorem ipsum dolor sit amet, consectetuer adipiscing', -36.484740000000002, -135.82141999999999, 'Y3G 7Y5', 0, 0, 'ROPECLIMB', 138, 3);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (87, 'Córdoba', 'Lorem ipsum', 6.7738399999999999, -155.07684, 'Y0T 7P7', 0, 0, 'BOULDER', 68, 4);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (88, 'La Valle/Wengen', 'Lorem ipsum dolor sit amet,', -1.4538800000000001, 53.879260000000002, 'Y3I 5W6', 0, 0, 'ROPECLIMB', 41, 2);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (89, 'Damme', 'Lorem ipsum dolor sit amet, consectetuer adipiscing', -77.100449999999995, 107.55513999999999, 'I6V 2M3', 0, 0, 'BOULDER', 140, 5);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (90, 'Francofonte', 'Lorem ipsum dolor sit amet,', 38.18036, -43.974350000000001, 'D5I 0B5', 0, 0, 'BOULDER', 33, 5);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (91, 'Güssing', 'Lorem', 42.408720000000002, 102.62464, 'F8B 2S5', 0, 0, 'ROPECLIMB', 69, 2);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (92, 'Acquafondata', 'Lorem ipsum', 20.003419999999998, 122.38596, 'G1N 2C7', 0, 0, 'BOULDER', 51, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (93, 'Campbeltown', 'Lorem ipsum', -75.549390000000002, -4.9561500000000001, 'Q3C 1R7', 0, 0, 'BOULDER', 173, 3);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (94, 'Duque de Caxias', 'Lorem ipsum dolor sit amet, consectetuer', -84.816450000000003, -82.566230000000004, 'U4H 9T9', 0, 0, 'ROPECLIMB', 170, 3);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (95, 'Ede', 'Lorem', 15.94599, 30.235440000000001, 'W0Z 7U1', 0, 0, 'ROPECLIMB', 191, 2);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (96, 'Baidyabati', 'Lorem ipsum', -58.522509999999997, 21.252980000000001, 'R9V 3I8', 0, 0, 'BOULDER', 186, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (97, 'Veraval', 'Lorem ipsum dolor sit', 43.238169999999997, 168.63377, 'R2B 8I0', 0, 0, 'BOULDER', 163, 4);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (98, 'Driffield', 'Lorem', -30.034970000000001, 58.041530000000002, 'Y7P 1Z4', 0, 0, 'BOULDER', 18, 1);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (99, 'Oostmalle', 'Lorem ipsum dolor sit amet,', 32.06908, 70.549570000000003, 'L1G 5O0', 0, 0, 'BOULDER', 5, 3);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (100, 'Vietri di Potenza', 'Lorem ipsum dolor sit', -11.78069, 16.037800000000001, 'H5Z 1C8', 0, 0, 'BOULDER', 82, 4);
INSERT INTO public.spot (id, city, description, latitude, longitude, name, rateless, ratemore, type, country_id, memberspot_id) VALUES (1, 'Hexham', 'Lorem ipsum dolor sit', 71.648259999999993, -69.847059999999999, 'V3Y 3A3', 0, 0, 'BOULDER', 193, 1);


--
-- TOC entry 2879 (class 0 OID 58038)
-- Dependencies: 208
-- Data for Name: spot_topo; Type: TABLE DATA; Schema: public; Owner: ocp
--

INSERT INTO public.spot_topo (spots_id, topos_id) VALUES (1, 1);
INSERT INTO public.spot_topo (spots_id, topos_id) VALUES (2, 4);


--
-- TOC entry 2881 (class 0 OID 58043)
-- Dependencies: 210
-- Data for Name: topo; Type: TABLE DATA; Schema: public; Owner: ocp
--

INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (2, 'Wilma Martin', true, 'Lorem ipsum dolor sit amet,', 'Lacinia At Iaculis LLC', 'calcaire', 'Mazowieckie', 1995, 195, 2);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (3, 'Fritz Delaney', true, 'Lorem ipsum dolor sit amet,', 'Enim Mi LLC', 'calcaire', 'Arizona', 1922, 44, 1);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (5, 'Montana Osborn', true, 'Lorem', 'Adipiscing PC', 'hard', 'CV', 1992, 27, 2);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (6, 'Eagan Nieves', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 'Hendrerit Associates', 'blue', 'MA', 1990, 194, 2);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (7, 'Shafira Hopper', true, 'Lorem ipsum', 'Elit Pede Malesuada Limited', 'blue', 'L', 1955, 138, 3);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (8, 'Margaret Velazquez', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 'Fringilla Foundation', 'hard', 'IV', 1972, 172, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (9, 'Ivan Yates', true, 'Lorem ipsum', 'Mauris Nulla Integer Institute', 'blue', 'N.', 1992, 55, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (10, 'Giacomo Neal', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur', 'Non Corp.', 'chill', 'Henegouwen', 1959, 182, 1);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (11, 'Rose Lee', true, 'Lorem ipsum dolor', 'Arcu Curabitur Ut Inc.', 'violet', 'Dalarnas län', 2015, 131, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (12, 'Mannix Castaneda', true, 'Lorem', 'Sed Sem Incorporated', 'violet', 'BC', 1922, 68, 1);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (13, 'Alden Cote', true, 'Lorem ipsum dolor sit', 'Nec Ante LLC', 'montagne', 'Mississippi', 1915, 35, 4);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (14, 'Dylan Hancock', true, 'Lorem ipsum dolor sit amet, consectetuer', 'Suscipit Est Ac Incorporated', 'violet', 'Aragón', 1901, 111, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (15, 'Stuart Kennedy', true, 'Lorem ipsum dolor sit amet,', 'Non Industries', 'blue', 'V', 1928, 153, 1);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (16, 'Jillian Sykes', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 'Sit Corp.', 'chill', 'Tarapacá', 2011, 189, 3);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (17, 'Hu Walls', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed', 'Euismod LLC', 'hard', 'South Australia', 1948, 44, 2);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (18, 'Bevis Jennings', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed', 'Augue Sed Foundation', 'red', 'Maharastra', 2014, 148, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (19, 'Gannon Mckee', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 'Lobortis Tellus Corporation', 'orange', 'VII', 1970, 68, 3);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (20, 'Drake Rice', true, 'Lorem', 'Dolor Dolor Institute', 'blue', 'Adana', 1914, 114, 3);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (21, 'Shana Albert', true, 'Lorem ipsum dolor sit', 'Etiam Limited', 'granite', 'BR', 1917, 29, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (22, 'Yardley Stokes', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur', 'Risus Industries', 'red', 'Ontario', 1973, 172, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (23, 'Brynn Keith', true, 'Lorem', 'Vulputate Industries', 'desert', 'QC', 1905, 62, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (24, 'Gwendolyn Hodges', true, 'Lorem', 'A Enim Suspendisse Incorporated', 'mer', 'Ulster', 1980, 32, 2);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (25, 'Ursa Richard', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed', 'Etiam Consulting', 'calcaire', 'MAR', 2003, 76, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (26, 'Melissa Miles', true, 'Lorem', 'Luctus Corporation', 'desert', 'Ontario', 1954, 3, 4);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (27, 'Aline Flynn', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed', 'Et Eros Proin Associates', 'violet', 'Antofagasta', 1946, 192, 1);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (28, 'Emma Blevins', true, 'Lorem', 'Malesuada Institute', 'montagne', 'VIC', 1988, 3, 4);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (29, 'Carla Mcdonald', true, 'Lorem', 'Feugiat Institute', 'yellow', 'Kano', 1983, 162, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (30, 'Nell Rush', true, 'Lorem ipsum dolor sit amet,', 'Sagittis Augue Institute', 'violet', 'Heredia', 1902, 113, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (31, 'Mari Alvarado', true, 'Lorem ipsum dolor sit', 'Eget Corporation', 'montagne', 'Stockholms län', 2003, 78, 3);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (32, 'Macon Dawson', true, 'Lorem ipsum dolor sit amet,', 'Mollis Corporation', 'calcaire', 'Nevada', 1979, 44, 3);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (33, 'Larissa Skinner', true, 'Lorem ipsum dolor', 'Sodales Nisi Magna Industries', 'violet', 'NI', 1980, 5, 1);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (34, 'Mufutau Michael', true, 'Lorem ipsum dolor sit', 'Natoque Penatibus Et Foundation', 'chill', 'California', 1996, 52, 1);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (35, 'Kimberly Cantrell', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 'Porttitor Corporation', 'indigo', 'QC', 1986, 159, 1);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (36, 'Gary Terry', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 'Nunc Inc.', 'granite', 'Pennsylvania', 2008, 3, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (37, 'Fulton Yang', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed', 'Nostra Per Inceptos Consulting', 'blue', 'Victoria', 1905, 129, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (38, 'Clementine Mejia', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed', 'Tellus Consulting', 'green', 'MG', 1986, 121, 2);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (39, 'Dominic Powell', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 'At Pretium Aliquet LLP', 'red', 'New Brunswick', 2011, 175, 2);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (40, 'Nayda Simon', true, 'Lorem ipsum', 'Nascetur Ridiculus Mus Limited', 'blue', 'Lower Austria', 1979, 68, 2);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (41, 'Flavia Burris', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed', 'Tempor Lorem Incorporated', 'desert', 'Montana', 1993, 165, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (42, 'Amal Griffin', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed', 'Aenean Euismod Mauris PC', 'calcaire', 'Valparaíso', 2015, 63, 4);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (43, 'Stacy Molina', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur', 'Aenean Euismod Mauris Ltd', 'violet', 'NI', 1931, 130, 3);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (44, 'Lacota Mcmillan', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 'Leo Vivamus LLP', 'blue', 'San José', 2018, 72, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (45, 'Ralph Marks', true, 'Lorem ipsum dolor sit amet,', 'Mauris Sagittis Placerat Company', 'granite', 'Pará', 1993, 104, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (46, 'Angela Howard', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed', 'Tempus Scelerisque Institute', 'green', 'NI', 1982, 127, 2);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (47, 'Neil Fulton', true, 'Lorem', 'Luctus Aliquet PC', 'chill', 'Arizona', 1915, 145, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (48, 'Wayne Soto', true, 'Lorem ipsum dolor sit', 'Ornare Facilisis Eget Foundation', 'granite', 'Wie', 1954, 159, 1);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (49, 'Xerxes Schwartz', true, 'Lorem', 'Et Magnis Dis LLC', 'chill', 'Zachodniopomorskie', 1939, 110, 3);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (50, 'Yoko Taylor', true, 'Lorem ipsum dolor', 'Ipsum Dolor LLP', 'blue', 'Bahia', 1952, 156, 2);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (51, 'Darius Huff', true, 'Lorem ipsum dolor', 'Etiam Corp.', 'granite', 'V', 1956, 96, 4);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (52, 'Reagan Bridges', true, 'Lorem ipsum dolor sit', 'In LLP', 'green', 'BE', 1948, 37, 3);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (53, 'Delilah Burgess', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 'In At Inc.', 'yellow', 'DE', 1955, 132, 2);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (54, 'Helen Hutchinson', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur', 'Eu Ltd', 'mer', 'LU', 1959, 74, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (55, 'Phoebe Quinn', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 'Sem Ltd', 'mer', 'DE', 1914, 138, 3);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (56, 'Xenos Gibbs', true, 'Lorem ipsum dolor sit amet, consectetuer', 'Diam Pellentesque Habitant Industries', 'desert', 'Kansas', 1959, 170, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (57, 'Gareth Burnett', true, 'Lorem ipsum dolor sit', 'Ultrices Duis Institute', 'violet', 'HB', 1914, 23, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (58, 'Gail Coleman', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 'Aliquet Lobortis Nisi Ltd', 'chill', 'U', 1971, 5, 3);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (59, 'Kelly Patton', true, 'Lorem', 'Vehicula Corp.', 'green', 'PB', 1917, 184, 1);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (60, 'Gillian Ball', true, 'Lorem', 'Mi Tempor PC', 'calcaire', 'IL', 1970, 185, 2);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (61, 'Mannix Carey', true, 'Lorem ipsum dolor sit', 'Vestibulum Lorem Sit Corp.', 'granite', 'SJ', 1954, 53, 3);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (4, 'Minerva Case', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 'Neque Et Company', 'hard', 'Hawaii', 1933, 40, 1);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (62, 'Mary Bowers', true, 'Lorem ipsum', 'Ipsum Ltd', 'mer', 'Wie', 1996, 189, 1);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (63, 'Anastasia Randolph', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur', 'Eu Corp.', 'mer', 'Hamburg', 1905, 123, 1);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (64, 'Willow Porter', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 'In Scelerisque Limited', 'blue', 'Minas Gerais', 1916, 117, 1);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (65, 'Britanney Greer', true, 'Lorem ipsum dolor sit', 'Ut Incorporated', 'orange', 'Puglia', 1916, 124, 3);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (66, 'Ora Baldwin', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 'Blandit Enim Consequat Corp.', 'mer', 'Stockholms län', 1938, 18, 2);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (67, 'Olivia Robbins', true, 'Lorem ipsum dolor sit amet, consectetuer', 'Mauris Ltd', 'calcaire', 'SC', 1916, 43, 1);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (68, 'Isaac Bird', true, 'Lorem ipsum dolor sit', 'Nulla Aliquet Proin PC', 'yellow', 'Oyo', 2005, 195, 4);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (69, 'Charissa Alford', true, 'Lorem ipsum', 'Lectus Quis Limited', 'blue', 'Coquimbo', 1942, 174, 2);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (70, 'Jael Floyd', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 'Parturient PC', 'green', 'Z.', 1944, 102, 4);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (71, 'Kirk Torres', true, 'Lorem ipsum dolor sit amet, consectetuer', 'Lectus Justo Eu Consulting', 'yellow', 'LU', 1907, 157, 4);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (72, 'Vera Waller', true, 'Lorem', 'Iaculis Odio Industries', 'desert', 'CT', 1926, 37, 2);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (73, 'Francesca Cantrell', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 'Risus Duis Corp.', 'chill', 'Ontario', 1992, 150, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (74, 'Jillian Mcneil', true, 'Lorem ipsum dolor sit amet,', 'Risus PC', 'calcaire', 'Adana', 2005, 73, 1);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (75, 'Jolie Tillman', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 'Elementum Sem Company', 'calcaire', 'Paraíba', 1985, 66, 1);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (76, 'Colorado Crane', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 'Nibh Quisque LLC', 'hard', 'SK', 1954, 27, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (77, 'Dakota Cardenas', true, 'Lorem ipsum dolor sit amet, consectetuer', 'Etiam Vestibulum Massa Company', 'yellow', 'GA', 1906, 7, 1);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (78, 'Maxine Cervantes', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur', 'Elit Aliquam Consulting', 'desert', 'HB', 1998, 100, 3);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (79, 'Thomas Hodges', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 'Dis Consulting', 'granite', 'Limón', 2008, 24, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (80, 'Moana Mccarty', true, 'Lorem ipsum dolor sit amet,', 'Eu Eleifend Corp.', 'hard', 'Namen', 1970, 7, 3);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (81, 'Omar Huff', true, 'Lorem ipsum dolor sit amet, consectetuer', 'Integer Industries', 'chill', 'Washington', 1971, 63, 2);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (82, 'Blaine Torres', true, 'Lorem ipsum', 'Ipsum Company', 'desert', 'MOL', 1976, 134, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (83, 'Griffith Reilly', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 'Rhoncus Inc.', 'hard', 'Sicilia', 1981, 23, 1);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (84, 'Amos Miller', true, 'Lorem ipsum dolor sit amet, consectetuer', 'Amet Corporation', 'hard', 'Vienna', 1914, 45, 3);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (85, 'Wayne Drake', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur', 'Faucibus Corp.', 'calcaire', 'MI', 2003, 137, 1);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (86, 'Griffith Luna', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 'Iaculis Quis PC', 'hard', 'Gujarat', 1951, 176, 3);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (87, 'Jerome Gilmore', true, 'Lorem', 'Justo Proin Non Associates', 'granite', 'PR', 2018, 40, 4);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (88, 'Shelby Silva', true, 'Lorem ipsum dolor sit amet,', 'Sem Incorporated', 'montagne', 'NI', 2006, 156, 3);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (89, 'Colton Aguirre', true, 'Lorem', 'Accumsan Company', 'desert', 'CO', 1910, 150, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (90, 'Oprah Conley', true, 'Lorem ipsum', 'Eget Ipsum LLC', 'mer', 'RJ', 1951, 114, 1);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (91, 'Raya Wells', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 'Tristique Incorporated', 'blue', 'Berlin', 1981, 159, 2);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (92, 'Armand Robinson', true, 'Lorem ipsum dolor sit amet, consectetuer', 'Ipsum Corp.', 'granite', 'BA', 1999, 148, 4);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (93, 'Dustin Howe', true, 'Lorem', 'Tellus Phasellus Industries', 'mer', 'Hamburg', 1901, 82, 1);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (94, 'Abra Silva', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur', 'Natoque Penatibus Et Consulting', 'indigo', 'UP', 1921, 2, 4);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (95, 'Joseph Harrison', true, 'Lorem ipsum dolor sit', 'Enim Corporation', 'violet', 'North Island', 2000, 171, 3);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (96, 'Naomi George', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 'Tincidunt Consulting', 'granite', 'OY', 1973, 25, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (97, 'Tucker Clay', true, 'Lorem ipsum dolor', 'Amet Luctus Limited', 'granite', 'AB', 1924, 10, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (98, 'Denise Lawrence', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur', 'Massa Mauris Inc.', 'granite', 'Biobío', 1925, 45, 1);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (99, 'Vielka Herrera', true, 'Lorem ipsum dolor sit amet, consectetuer', 'Eget Metus Eu Ltd', 'mer', 'Madhya Pradesh', 2017, 77, 4);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (100, 'Amy Bruce', true, 'Lorem ipsum dolor sit', 'Integer Consulting', 'green', 'MD', 1937, 15, 5);
INSERT INTO public.topo (id, author, available, description, edition, keywords, name, publishedyear, country_id, owner_id) VALUES (1, 'Kathleen Osborn', true, 'Lorem ipsum dolor sit amet, consectetuer adipiscing', 'Velit Foundation', 'montagne', 'AB', 1922, 2, 2);


--
-- TOC entry 2898 (class 0 OID 0)
-- Dependencies: 196
-- Name: booking_id_seq; Type: SEQUENCE SET; Schema: public; Owner: ocp
--

SELECT pg_catalog.setval('public.booking_id_seq', 1, false);


--
-- TOC entry 2899 (class 0 OID 0)
-- Dependencies: 198
-- Name: comment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: ocp
--

SELECT pg_catalog.setval('public.comment_id_seq', 202, true);


--
-- TOC entry 2900 (class 0 OID 0)
-- Dependencies: 200
-- Name: country_id_seq; Type: SEQUENCE SET; Schema: public; Owner: ocp
--

SELECT pg_catalog.setval('public.country_id_seq', 1, false);


--
-- TOC entry 2901 (class 0 OID 0)
-- Dependencies: 202
-- Name: member_id_seq; Type: SEQUENCE SET; Schema: public; Owner: ocp
--

SELECT pg_catalog.setval('public.member_id_seq', 5, true);


--
-- TOC entry 2902 (class 0 OID 0)
-- Dependencies: 204
-- Name: route_id_seq; Type: SEQUENCE SET; Schema: public; Owner: ocp
--

SELECT pg_catalog.setval('public.route_id_seq', 102, true);


--
-- TOC entry 2903 (class 0 OID 0)
-- Dependencies: 206
-- Name: spot_id_seq; Type: SEQUENCE SET; Schema: public; Owner: ocp
--

SELECT pg_catalog.setval('public.spot_id_seq', 100, true);


--
-- TOC entry 2904 (class 0 OID 0)
-- Dependencies: 209
-- Name: topo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: ocp
--

SELECT pg_catalog.setval('public.topo_id_seq', 100, true);


--
-- TOC entry 2720 (class 2606 OID 57994)
-- Name: booking booking_pkey; Type: CONSTRAINT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.booking
    ADD CONSTRAINT booking_pkey PRIMARY KEY (id);


--
-- TOC entry 2722 (class 2606 OID 58002)
-- Name: comment comment_pkey; Type: CONSTRAINT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_pkey PRIMARY KEY (id);


--
-- TOC entry 2724 (class 2606 OID 58010)
-- Name: country country_pkey; Type: CONSTRAINT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.country
    ADD CONSTRAINT country_pkey PRIMARY KEY (id);


--
-- TOC entry 2726 (class 2606 OID 58021)
-- Name: member member_pkey; Type: CONSTRAINT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.member
    ADD CONSTRAINT member_pkey PRIMARY KEY (id);


--
-- TOC entry 2728 (class 2606 OID 58029)
-- Name: route route_pkey; Type: CONSTRAINT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.route
    ADD CONSTRAINT route_pkey PRIMARY KEY (id);


--
-- TOC entry 2730 (class 2606 OID 58037)
-- Name: spot spot_pkey; Type: CONSTRAINT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.spot
    ADD CONSTRAINT spot_pkey PRIMARY KEY (id);


--
-- TOC entry 2732 (class 2606 OID 58051)
-- Name: topo topo_pkey; Type: CONSTRAINT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT topo_pkey PRIMARY KEY (id);


--
-- TOC entry 2734 (class 2606 OID 58057)
-- Name: booking fk5cx0gthowuhvjfyxgplwqrksx; Type: FK CONSTRAINT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.booking
    ADD CONSTRAINT fk5cx0gthowuhvjfyxgplwqrksx FOREIGN KEY (topo_id) REFERENCES public.topo(id);


--
-- TOC entry 2733 (class 2606 OID 58052)
-- Name: booking fka8o2nmknj1tfj522anjjaofp3; Type: FK CONSTRAINT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.booking
    ADD CONSTRAINT fka8o2nmknj1tfj522anjjaofp3 FOREIGN KEY (booker_id) REFERENCES public.member(id);


--
-- TOC entry 2745 (class 2606 OID 58112)
-- Name: topo fkavsni4iwa1efgymfnyam7w43h; Type: FK CONSTRAINT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT fkavsni4iwa1efgymfnyam7w43h FOREIGN KEY (owner_id) REFERENCES public.member(id);


--
-- TOC entry 2738 (class 2606 OID 58077)
-- Name: route fke9ftdpjkcxo39klqamweyhhvv; Type: FK CONSTRAINT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.route
    ADD CONSTRAINT fke9ftdpjkcxo39klqamweyhhvv FOREIGN KEY (memberroute_id) REFERENCES public.member(id);


--
-- TOC entry 2736 (class 2606 OID 58067)
-- Name: comment fkgof482ugtnfdg4iuf74d8katt; Type: FK CONSTRAINT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT fkgof482ugtnfdg4iuf74d8katt FOREIGN KEY (route_id) REFERENCES public.route(id);


--
-- TOC entry 2739 (class 2606 OID 58082)
-- Name: route fki6n16u0446g0sees0jwpsc6as; Type: FK CONSTRAINT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.route
    ADD CONSTRAINT fki6n16u0446g0sees0jwpsc6as FOREIGN KEY (spot_id) REFERENCES public.spot(id);


--
-- TOC entry 2742 (class 2606 OID 58097)
-- Name: spot_topo fkieaunhiwaykhw8370w7tck3ro; Type: FK CONSTRAINT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.spot_topo
    ADD CONSTRAINT fkieaunhiwaykhw8370w7tck3ro FOREIGN KEY (topos_id) REFERENCES public.topo(id);


--
-- TOC entry 2735 (class 2606 OID 58062)
-- Name: comment fkk6nv8951lqnvhiwiyv1shcr2f; Type: FK CONSTRAINT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT fkk6nv8951lqnvhiwiyv1shcr2f FOREIGN KEY (membercomment_id) REFERENCES public.member(id);


--
-- TOC entry 2743 (class 2606 OID 58102)
-- Name: spot_topo fklggtort5bfp9g4nj6dnnovgc6; Type: FK CONSTRAINT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.spot_topo
    ADD CONSTRAINT fklggtort5bfp9g4nj6dnnovgc6 FOREIGN KEY (spots_id) REFERENCES public.spot(id);


--
-- TOC entry 2737 (class 2606 OID 58072)
-- Name: comment fknbe15uxcbbk4yv2ladeeklael; Type: FK CONSTRAINT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT fknbe15uxcbbk4yv2ladeeklael FOREIGN KEY (spot_id) REFERENCES public.spot(id);


--
-- TOC entry 2740 (class 2606 OID 58087)
-- Name: spot fknvs50r7xtvon55x67q9k6fn31; Type: FK CONSTRAINT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.spot
    ADD CONSTRAINT fknvs50r7xtvon55x67q9k6fn31 FOREIGN KEY (country_id) REFERENCES public.country(id);


--
-- TOC entry 2744 (class 2606 OID 58107)
-- Name: topo fksjixjof5sup0fbpyn7wbwweby; Type: FK CONSTRAINT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT fksjixjof5sup0fbpyn7wbwweby FOREIGN KEY (country_id) REFERENCES public.country(id);


--
-- TOC entry 2741 (class 2606 OID 58092)
-- Name: spot fkt2kwetlieadavb45vh1fnvuv3; Type: FK CONSTRAINT; Schema: public; Owner: ocp
--

ALTER TABLE ONLY public.spot
    ADD CONSTRAINT fkt2kwetlieadavb45vh1fnvuv3 FOREIGN KEY (memberspot_id) REFERENCES public.member(id);


SET SESSION AUTHORIZATION 'postgres';

--
-- TOC entry 2889 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2018-12-08 15:44:09

--
-- PostgreSQL database dump complete
--

