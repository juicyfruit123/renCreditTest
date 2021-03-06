#language: ru
Функционал: : Вклады

  Структура сценария: : 1
    Когда выбран пункт меню "Вклады"
    Когда выбрана валюта - "<currency>"
    Когда заполнена сумма вклада"<sumDeposit>"
    Когда выбран срок вклада "<periodDeposit>"
    Когда заполнена сумма ежемесячного пополнения"<monthReplenish>"
    Когда отмечено "Ежемесячная капитализация"
    И отмечено "Частичное снятие" "<bool>"
    Тогда проверить значения полей:
      | Название вклада          | <name>      |
      | Ставка                   | <rate>      |
      | Начислено %              | <earned>    |
      | Пополнение за 6 месяцев  | <replenish> |
      | К снятию через 6 месяцев | <result>    |

    Примеры:
      | currency | sumDeposit | periodDeposit | monthReplenish | bool  | name                    | rate  | earned    | replenish | result     |
      | Рубли    | 300000     | 6 месяцев     | 50000          | false | Ренессанс Накопительный | 5.35% | 11 383,43 | 250 000   | 561 383,43 |
      | Рубли    | 500000     | 6 месяцев     | 70000          | true  | Без границ              | 5.15% | 17 400,49 | 350 000   | 867 400,49 |