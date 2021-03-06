PGDMP     5    +                x           webpages    12.2    12.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16393    webpages    DATABASE     �   CREATE DATABASE webpages WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United Kingdom.1252' LC_CTYPE = 'English_United Kingdom.1252';
    DROP DATABASE webpages;
                postgres    false                        2615    16432    users    SCHEMA        CREATE SCHEMA users;
    DROP SCHEMA users;
                postgres    false            �            1259    16441    css_rule_sets    TABLE     g   CREATE TABLE users.css_rule_sets (
    _id bigint NOT NULL,
    css_rule_set character varying(255)
);
     DROP TABLE users.css_rule_sets;
       users         heap    postgres    false    6            �            1259    16455    hibernate_sequence    SEQUENCE     z   CREATE SEQUENCE users.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE users.hibernate_sequence;
       users          postgres    false    6            �            1259    16502    injection_html    TABLE     '   CREATE TABLE users.injection_html (
);
 !   DROP TABLE users.injection_html;
       users         heap    postgres    false    6            �            1259    16433    user_details    TABLE     =   CREATE TABLE users.user_details (
    _id bigint NOT NULL
);
    DROP TABLE users.user_details;
       users         heap    postgres    false    6            �            1259    16450    webpage_css_details    TABLE     �   CREATE TABLE users.webpage_css_details (
    _id bigint NOT NULL,
    url character varying(255),
    css_rule_set_id bigint NOT NULL,
    user_id bigint NOT NULL
);
 &   DROP TABLE users.webpage_css_details;
       users         heap    postgres    false    6                      0    16441    css_rule_sets 
   TABLE DATA           9   COPY users.css_rule_sets (_id, css_rule_set) FROM stdin;
    users          postgres    false    204                    0    16502    injection_html 
   TABLE DATA           '   COPY users.injection_html  FROM stdin;
    users          postgres    false    207   �                 0    16433    user_details 
   TABLE DATA           *   COPY users.user_details (_id) FROM stdin;
    users          postgres    false    203                    0    16450    webpage_css_details 
   TABLE DATA           P   COPY users.webpage_css_details (_id, url, css_rule_set_id, user_id) FROM stdin;
    users          postgres    false    205   S                  0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('users.hibernate_sequence', 406, true);
          users          postgres    false    206            �
           2606    16486     css_rule_sets css_rule_sets_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY users.css_rule_sets
    ADD CONSTRAINT css_rule_sets_pkey PRIMARY KEY (_id);
 I   ALTER TABLE ONLY users.css_rule_sets DROP CONSTRAINT css_rule_sets_pkey;
       users            postgres    false    204            �
           2606    16463    user_details user_details_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY users.user_details
    ADD CONSTRAINT user_details_pkey PRIMARY KEY (_id);
 G   ALTER TABLE ONLY users.user_details DROP CONSTRAINT user_details_pkey;
       users            postgres    false    203            �
           2606    16454 ,   webpage_css_details webpage_css_details_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY users.webpage_css_details
    ADD CONSTRAINT webpage_css_details_pkey PRIMARY KEY (_id);
 U   ALTER TABLE ONLY users.webpage_css_details DROP CONSTRAINT webpage_css_details_pkey;
       users            postgres    false    205            �
           2606    16487 #   webpage_css_details css_rule_set_id    FK CONSTRAINT     �   ALTER TABLE ONLY users.webpage_css_details
    ADD CONSTRAINT css_rule_set_id FOREIGN KEY (css_rule_set_id) REFERENCES users.css_rule_sets(_id) NOT VALID;
 L   ALTER TABLE ONLY users.webpage_css_details DROP CONSTRAINT css_rule_set_id;
       users          postgres    false    2705    204    205               �  x��Xmo�6���
�E��z����뀀�h��,���߾#E9�-�R�9@��"���=�By��>;;�BP�p
�VKg�3�Y8���·����0��շ\�]�-���	�v�_:�2^�x�K�;?�Q���`�'K-`t�D!��<@��n�7 ���ѠV.�t�k�n$HfF3&����NV[v6�z��Q�-x^.�+�0��B5�����,�b�����c��k�e�����&��$3wg�sh�������K3�[9����,+�[�b���t���'�<��5�XJ�hX/�1�a�����4�%3�Ⱥp>@:2�r=<��4;aY��8���)��|b^��ػ�^�?@?|+��f
ăH�`�d���|̘�#ׁJnF�$�Ұ���4�7C
��:�{~�h�O�?�`��kt�d��(���)��p��P(瑮�my�pOy~)�m��d��<\���J�fkt����{�lM.w����Ó�l���	������󂷴R 'J�o+e�|��������Iz<��R�q�hI�逸9D�ԩD�54�E�3����iN��/�����C*����ոg%��(���[*s^���0�ngLK��v}�gy��>�a��ք�X�G�Z�m+��n����`�7�jE��Z�^����D�r�
��r�� ��니Z9gt��$��-�8N��a�OZ
����CY+~ާ��qʶ���j����,��	g��(M��Q�8M�⑉®��SߛVz}o4��ꠧ�z���n�=&Fypt�h����M�s�wݳ}�]�V��}"��pA-r����!7���An�����D�Md�������"ݮ�f���E�.��S�m�͟�2Z�L>��,6�oޭ�B�����������>�7�%�P�m��u��(r�\mP�bAk�V^d��k&�l,������w4�.���$��:t>�6k I׈��5/
WH�<�+k����QKFm�h��fz�杤��`���T(%�=��k(D��a��HH�`NZ�r�b��-Vv�ۊ��f�/�Y��c�_��^�'6�91b|4���!)��S�S���<�K���5�팕b��;���\k뻾������ֈ'o���S��R�� ��i�ڿZ�5�]�ҝ~�H�ZH��et�L Ys-��p����pM�52�_���X|bzH�i�,�ה?�K`<��+ '�����r�qkHD�~<lkV,J�>��-E��?E
��}�%��)k�m��Ɖ!�xQ�\Zg�V
L��cb���9������?�<e�Z�vuoj�7-v���Q���5�xҁ�� ͏�M����=�-�Auh� Q��407�ϭ6ڰ��=�ǯ�_}$m������>~���l�إ}��!d�J��
g�e#EI���ZA�a�KJi/ZQt��$��� 0�HgCTWte�"��x�v�(2��gZ�N����$]x�7���?ܻ��� �k��            x������ � �         *   x��A 0�����v�.�cv��A�=d<X8�I�|s��           x����j�0E��ǘ苚7��.ZJ�086�N5)&m��(]eQq�#
-���O{b̺��0�j�M����V��� �,%y� OU���HT���D��e��|=�z��c��|=�z��c��|=n���8����ݍ�+;��kV�Y��� �ѭ�a������q1w�;���{Q��P�=��'R�����l?3����xg�[�p���^��~�~�9�r�^��a�޽��"��!�e�\2.8�?J�c���|-Y�["�6��q��o�����x     