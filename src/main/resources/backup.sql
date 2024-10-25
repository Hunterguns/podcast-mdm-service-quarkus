PGDMP  &    7                |            postgres    16.3 (Debian 16.3-1.pgdg120+1)    16.3 (Debian 16.3-1.pgdg120+1) 0    y           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            z           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            {           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            |           1262    5    postgres    DATABASE     s   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';
    DROP DATABASE postgres;
                postgres    false            }           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    3452                        3079    16518 	   uuid-ossp 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;
    DROP EXTENSION "uuid-ossp";
                   false            ~           0    0    EXTENSION "uuid-ossp"    COMMENT     W   COMMENT ON EXTENSION "uuid-ossp" IS 'generate universally unique identifiers (UUIDs)';
                        false    2            �            1259    16479 
   categories    TABLE     y   CREATE TABLE public.categories (
    id uuid NOT NULL,
    name character varying(100) NOT NULL,
    description text
);
    DROP TABLE public.categories;
       public         heap    postgres    false            �            1259    16410    episodes    TABLE     �  CREATE TABLE public.episodes (
    id uuid NOT NULL,
    podcast_id uuid,
    title character varying(200) NOT NULL,
    description text,
    audio_file_url character varying(500) NOT NULL,
    duration integer,
    publish_date timestamp with time zone,
    episode_number integer,
    season_number integer,
    created_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP
);
    DROP TABLE public.episodes;
       public         heap    postgres    false            �            1259    16442    playback_history    TABLE     �   CREATE TABLE public.playback_history (
    id uuid NOT NULL,
    user_id uuid,
    episode_id uuid,
    played_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    progress integer
);
 $   DROP TABLE public.playback_history;
       public         heap    postgres    false            �            1259    16488    podcast_categories    TABLE     h   CREATE TABLE public.podcast_categories (
    podcast_id uuid NOT NULL,
    category_id uuid NOT NULL
);
 &   DROP TABLE public.podcast_categories;
       public         heap    postgres    false            �            1259    16424    podcast_subscriptions    TABLE     �   CREATE TABLE public.podcast_subscriptions (
    id uuid NOT NULL,
    user_id uuid,
    podcast_id uuid,
    subscribed_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP
);
 )   DROP TABLE public.podcast_subscriptions;
       public         heap    postgres    false            �            1259    16395    podcasts    TABLE     �  CREATE TABLE public.podcasts (
    id uuid NOT NULL,
    creator_id uuid,
    title character varying(200) NOT NULL,
    description text,
    cover_image_url character varying(500),
    language character varying(15),
    is_explicit boolean DEFAULT false,
    created_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP
);
    DROP TABLE public.podcasts;
       public         heap    postgres    false            �            1259    16503    premium_subscriptions    TABLE     �  CREATE TABLE public.premium_subscriptions (
    id uuid NOT NULL,
    user_id uuid,
    start_date timestamp with time zone NOT NULL,
    end_date timestamp with time zone,
    subscription_type character varying(20),
    status character varying(20),
    created_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP
);
 )   DROP TABLE public.premium_subscriptions;
       public         heap    postgres    false            �            1259    16458    ratings    TABLE     ]  CREATE TABLE public.ratings (
    id uuid NOT NULL,
    user_id uuid,
    podcast_id uuid,
    rating smallint,
    review_text text,
    created_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT ratings_rating_check CHECK (((rating >= 1) AND (rating <= 5)))
);
    DROP TABLE public.ratings;
       public         heap    postgres    false            �            1259    16388    users    TABLE     �  CREATE TABLE public.users (
    id uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    username character varying(50) NOT NULL,
    email character varying(100) NOT NULL,
    user_type character varying(20) NOT NULL,
    created_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    hashed_password character varying(255)
);
    DROP TABLE public.users;
       public         heap    postgres    false    2            t          0    16479 
   categories 
   TABLE DATA           ;   COPY public.categories (id, name, description) FROM stdin;
    public          postgres    false    222   �A       p          0    16410    episodes 
   TABLE DATA           �   COPY public.episodes (id, podcast_id, title, description, audio_file_url, duration, publish_date, episode_number, season_number, created_at, updated_at) FROM stdin;
    public          postgres    false    218   �A       r          0    16442    playback_history 
   TABLE DATA           X   COPY public.playback_history (id, user_id, episode_id, played_at, progress) FROM stdin;
    public          postgres    false    220   �A       u          0    16488    podcast_categories 
   TABLE DATA           E   COPY public.podcast_categories (podcast_id, category_id) FROM stdin;
    public          postgres    false    223   �A       q          0    16424    podcast_subscriptions 
   TABLE DATA           W   COPY public.podcast_subscriptions (id, user_id, podcast_id, subscribed_at) FROM stdin;
    public          postgres    false    219   B       o          0    16395    podcasts 
   TABLE DATA           �   COPY public.podcasts (id, creator_id, title, description, cover_image_url, language, is_explicit, created_at, updated_at) FROM stdin;
    public          postgres    false    217   2B       v          0    16503    premium_subscriptions 
   TABLE DATA           �   COPY public.premium_subscriptions (id, user_id, start_date, end_date, subscription_type, status, created_at, updated_at) FROM stdin;
    public          postgres    false    224   OB       s          0    16458    ratings 
   TABLE DATA           g   COPY public.ratings (id, user_id, podcast_id, rating, review_text, created_at, updated_at) FROM stdin;
    public          postgres    false    221   lB       n          0    16388    users 
   TABLE DATA           h   COPY public.users (id, username, email, user_type, created_at, updated_at, hashed_password) FROM stdin;
    public          postgres    false    216   �B       �           2606    16487    categories categories_name_key 
   CONSTRAINT     Y   ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_name_key UNIQUE (name);
 H   ALTER TABLE ONLY public.categories DROP CONSTRAINT categories_name_key;
       public            postgres    false    222            �           2606    16485    categories categories_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.categories DROP CONSTRAINT categories_pkey;
       public            postgres    false    222            �           2606    16418    episodes episodes_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.episodes
    ADD CONSTRAINT episodes_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.episodes DROP CONSTRAINT episodes_pkey;
       public            postgres    false    218            �           2606    16447 &   playback_history playback_history_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.playback_history
    ADD CONSTRAINT playback_history_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.playback_history DROP CONSTRAINT playback_history_pkey;
       public            postgres    false    220            �           2606    16492 *   podcast_categories podcast_categories_pkey 
   CONSTRAINT     }   ALTER TABLE ONLY public.podcast_categories
    ADD CONSTRAINT podcast_categories_pkey PRIMARY KEY (podcast_id, category_id);
 T   ALTER TABLE ONLY public.podcast_categories DROP CONSTRAINT podcast_categories_pkey;
       public            postgres    false    223    223            �           2606    16429 0   podcast_subscriptions podcast_subscriptions_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.podcast_subscriptions
    ADD CONSTRAINT podcast_subscriptions_pkey PRIMARY KEY (id);
 Z   ALTER TABLE ONLY public.podcast_subscriptions DROP CONSTRAINT podcast_subscriptions_pkey;
       public            postgres    false    219            �           2606    16431 B   podcast_subscriptions podcast_subscriptions_user_id_podcast_id_key 
   CONSTRAINT     �   ALTER TABLE ONLY public.podcast_subscriptions
    ADD CONSTRAINT podcast_subscriptions_user_id_podcast_id_key UNIQUE (user_id, podcast_id);
 l   ALTER TABLE ONLY public.podcast_subscriptions DROP CONSTRAINT podcast_subscriptions_user_id_podcast_id_key;
       public            postgres    false    219    219            �           2606    16404    podcasts podcasts_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.podcasts
    ADD CONSTRAINT podcasts_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.podcasts DROP CONSTRAINT podcasts_pkey;
       public            postgres    false    217            �           2606    16509 0   premium_subscriptions premium_subscriptions_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public.premium_subscriptions
    ADD CONSTRAINT premium_subscriptions_pkey PRIMARY KEY (id);
 Z   ALTER TABLE ONLY public.premium_subscriptions DROP CONSTRAINT premium_subscriptions_pkey;
       public            postgres    false    224            �           2606    16466    ratings ratings_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.ratings
    ADD CONSTRAINT ratings_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.ratings DROP CONSTRAINT ratings_pkey;
       public            postgres    false    221            �           2606    16468 &   ratings ratings_user_id_podcast_id_key 
   CONSTRAINT     p   ALTER TABLE ONLY public.ratings
    ADD CONSTRAINT ratings_user_id_podcast_id_key UNIQUE (user_id, podcast_id);
 P   ALTER TABLE ONLY public.ratings DROP CONSTRAINT ratings_user_id_podcast_id_key;
       public            postgres    false    221    221            �           2606    16394    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    216            �           2606    16419 !   episodes episodes_podcast_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.episodes
    ADD CONSTRAINT episodes_podcast_id_fkey FOREIGN KEY (podcast_id) REFERENCES public.podcasts(id);
 K   ALTER TABLE ONLY public.episodes DROP CONSTRAINT episodes_podcast_id_fkey;
       public          postgres    false    217    3263    218            �           2606    16453 1   playback_history playback_history_episode_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.playback_history
    ADD CONSTRAINT playback_history_episode_id_fkey FOREIGN KEY (episode_id) REFERENCES public.episodes(id);
 [   ALTER TABLE ONLY public.playback_history DROP CONSTRAINT playback_history_episode_id_fkey;
       public          postgres    false    220    3265    218            �           2606    16448 .   playback_history playback_history_user_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.playback_history
    ADD CONSTRAINT playback_history_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);
 X   ALTER TABLE ONLY public.playback_history DROP CONSTRAINT playback_history_user_id_fkey;
       public          postgres    false    216    220    3261            �           2606    16498 6   podcast_categories podcast_categories_category_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.podcast_categories
    ADD CONSTRAINT podcast_categories_category_id_fkey FOREIGN KEY (category_id) REFERENCES public.categories(id);
 `   ALTER TABLE ONLY public.podcast_categories DROP CONSTRAINT podcast_categories_category_id_fkey;
       public          postgres    false    3279    223    222            �           2606    16493 5   podcast_categories podcast_categories_podcast_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.podcast_categories
    ADD CONSTRAINT podcast_categories_podcast_id_fkey FOREIGN KEY (podcast_id) REFERENCES public.podcasts(id);
 _   ALTER TABLE ONLY public.podcast_categories DROP CONSTRAINT podcast_categories_podcast_id_fkey;
       public          postgres    false    217    223    3263            �           2606    16437 ;   podcast_subscriptions podcast_subscriptions_podcast_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.podcast_subscriptions
    ADD CONSTRAINT podcast_subscriptions_podcast_id_fkey FOREIGN KEY (podcast_id) REFERENCES public.podcasts(id);
 e   ALTER TABLE ONLY public.podcast_subscriptions DROP CONSTRAINT podcast_subscriptions_podcast_id_fkey;
       public          postgres    false    217    3263    219            �           2606    16432 8   podcast_subscriptions podcast_subscriptions_user_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.podcast_subscriptions
    ADD CONSTRAINT podcast_subscriptions_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);
 b   ALTER TABLE ONLY public.podcast_subscriptions DROP CONSTRAINT podcast_subscriptions_user_id_fkey;
       public          postgres    false    3261    219    216            �           2606    16405 !   podcasts podcasts_creator_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.podcasts
    ADD CONSTRAINT podcasts_creator_id_fkey FOREIGN KEY (creator_id) REFERENCES public.users(id);
 K   ALTER TABLE ONLY public.podcasts DROP CONSTRAINT podcasts_creator_id_fkey;
       public          postgres    false    216    3261    217            �           2606    16510 8   premium_subscriptions premium_subscriptions_user_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.premium_subscriptions
    ADD CONSTRAINT premium_subscriptions_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);
 b   ALTER TABLE ONLY public.premium_subscriptions DROP CONSTRAINT premium_subscriptions_user_id_fkey;
       public          postgres    false    224    216    3261            �           2606    16474    ratings ratings_podcast_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ratings
    ADD CONSTRAINT ratings_podcast_id_fkey FOREIGN KEY (podcast_id) REFERENCES public.podcasts(id);
 I   ALTER TABLE ONLY public.ratings DROP CONSTRAINT ratings_podcast_id_fkey;
       public          postgres    false    3263    217    221            �           2606    16469    ratings ratings_user_id_fkey    FK CONSTRAINT     {   ALTER TABLE ONLY public.ratings
    ADD CONSTRAINT ratings_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);
 F   ALTER TABLE ONLY public.ratings DROP CONSTRAINT ratings_user_id_fkey;
       public          postgres    false    221    216    3261            t      x������ � �      p      x������ � �      r      x������ � �      u      x������ � �      q      x������ � �      o      x������ � �      v      x������ � �      s      x������ � �      n      x������ � �     