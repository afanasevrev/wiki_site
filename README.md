```
Storyline (сюжет)
 ├── метаданные: title, subtitle, cover, epoch, region, tags, difficulty,
 │                duration_days, items_count, price, language, author(s)
 ├── Day 1 … Day N
 │     └── Item (выпуск) × 3–5
 │           ├── type: NEWS | BREAKING | INTERVIEW | ANALYTICS | QUOTE |
 │           │         RUMOR | DOCUMENT | MAP | INFOGRAPHIC | AD_ERA
 │           ├── slot: MORNING | DAY | EVENING | NIGHT | exact_time
 │           ├── headline, lead, body (rich text), media
 │           ├── historical_date (реальная дата события)
 │           ├── reliability: CONFIRMED | RUMOR | PROPAGANDA  ← важная механика
 │           ├── sources (обязательно ≥1 для CONFIRMED)
 │           ├── glossary_terms
 │           └── debrief (опционально): «что было на самом деле»
 ├── Weekly digest × (N/7)
 ├── Quiz × (N/7) + финальный
 └── Final debrief + reading list
```
