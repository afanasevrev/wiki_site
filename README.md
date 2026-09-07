```sql
CREATE SCHEMA auth;
CREATE TYPE auth.user_status
AS ENUM ('active','blocked','pending_delete','deleted');
CREATE TYPE auth.oauth_provider
AS ENUM ('google','apple','vk','yandex');
CREATE TYPE auth.device_platform
AS ENUM ('ios','android','web');
CREATE TYPE auth.author_verif
AS ENUM ('none','pending','verified','rejected','revoked');
CREATE TYPE auth.tax_status
AS ENUM ('individual','self_employed','sole_proprietor','company');
CREATE TABLE auth.users (id               UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    email            CITEXT UNIQUE,                    -- NULL для гостей
    password_hash    TEXT,                             -- bcrypt/argon2, NULL при OAuth-only
    email_verified_at TIMESTAMPTZ,
    display_name     VARCHAR(80),
    avatar_media_id  UUID,                             -- FK добавляется после content.media_assets
    locale           VARCHAR(10)  NOT NULL DEFAULT 'ru',
    timezone         VARCHAR(64)  NOT NULL DEFAULT 'Europe/Moscow',
    is_guest         BOOLEAN      NOT NULL DEFAULT FALSE,
    status           auth.user_status NOT NULL DEFAULT 'active',
    last_login_at    TIMESTAMPTZ,
    created_at       TIMESTAMPTZ  NOT NULL DEFA
```
