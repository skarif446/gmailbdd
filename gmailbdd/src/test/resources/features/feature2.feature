Feature: gmail login
Scenario Outline: validate Userid field
Given launch gmail site
When enter userid as "<x>" value
And click next
Then validate output for "<y>" criteria
And close site
Examples:
|          x         |      y           |
|     12715a0421     |     valid        |
|     12715a0422     |   invalid        |
|                    |   invalid        |

Scenario Outline: validate pwd field
Given launch gmail site
When enter userid as "12715a0421" value
And click next
And enter password as "<x>" value
And click pwd next
Then validate result for "<y>" criteria
And close site
Examples:
|          x         |      y           |
|     8139945701     |     valid        |
|     8139945702     |   invalid        |
|                    |   invalid        |




