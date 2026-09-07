```
erDiagram
    users ||--o{ user_roles : "имеет"
    roles ||--o{ user_roles : ""
    users ||--o{ oauth_accounts : "привязки"
    users ||--o{ user_devices : "устройства"
    users ||--|| user_settings : "настройки"
    users ||--o| author_profiles : "профиль автора"
    author_profiles ||--o{ author_documents : "документы"
    users ||--o{ refresh_tokens : "сессии"
    users ||--o{ agreement_acceptances : "принятые оферты"
    legal_agreements ||--o{ agreement_acceptances : ""
```
