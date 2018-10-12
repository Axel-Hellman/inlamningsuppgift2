# GruppInfo

Inlämningsuppgift2 i kursen Objektorienterad Modulering och Design (EDAF60) på LTH.  

Gruppmedlemmar:

Joakim Rudberg (dic15jru)

Johannes Törnblom (dic15jto)

Sandra Nyström (sa1741ny-s)

Axel Hellman (dic15ahe)


# Inlamningsuppgift2

Arbetat tid
Axel: 12h
Joakim: 17h
Johannes: 13h
Sandra: 17h

Länkar till UML-diagram för högre upplösning:

https://drive.google.com/file/d/1tuqmvXvF_crmn7ORuFA72fCdcStLgZE9/view?usp=sharing

1. Vilka klasser bör finnas för att representera ett kalkylark?

-En klass för att hantera/skapa celler
-En klass för att hantera hela matrisen av celler
-En klass för att hantera det grafiska för cellerna (troligtvis bättre med fler)
-En/flera klasser för att hantera de operationer som ska utföras i cellerna, beroende på hur välutvecklat man vill ha sitt kalkylark.



2. En ruta i kalkylarket skall kunna innehålla en text eller ett uttryck. Hur modellerar man detta?

En text modelleras som en String, och ger tillbaka värdet 0. Ett uttryck modelleras som en "floating point number". (en tom ruta har inget värde)


3. Hur skall man hantera uppdragsgivarens krav på minnesresurser?

Man sätter ett värde som bestämmer hur många rutor som ritas upp, och har även variabler för att fylla de celler som innehåller någon info, att visa denna. Så det är endast data som sparas och mängden celler som ska ritas, och var den ska vara placerad.


4. Vilka klasser skall vara observatörer och vilka skall observeras?

Observeras -> CurrentSlot 

Observatörer -> StatusLabel


5. Vilket paket och vilken klass skall hålla reda på vad som är "Current slot"?

Paket=gui
Klass=CurrentSlot



6. Vilken funktionalitet är redan färdig och hur fungerar den? Titta på klasserna i view-paketet och testkör.

(View =? gui)
Hantering för expressions (förhoppningsvis då detta står i instruktionerna) och det generella gränsnittet är färdigt. Men mycket av funktionaliteten saknas fortfarande, som att manövrera i matrisen och skicka in inputs. 


7. Det kan inträffa ett antal olika fel när man försöker ändra innehållet i ett kalkylark. Då skall undantag kastas. Var skall dessa undantag fångas och hanteras?

util -> XLException
expr -> ExprParser


8. Vilken klass används för att representera en adress i ett uttryck?

Expr.java



9. När ett uttryck som består av en adress skall beräknas används gränssnittet Environment. Vilken klass skall implementera gränssnittet? Varför använder man inte klassnamnet i stället för gränssnittet?




10. Om ett uttryck i kalkylarket refererar till sig själv, direkt eller indirekt, så kommer det att bli bekymmer vid beräkningen av uttryckets värde. Föreslå något sätt att upptäcka sådana cirkulära beroenden! Det finns en elegant lösning med hjälp av strategimönstret som du får chansen att upptäcka. Om du inte hittar den så kommer handledaren att avslöja den.

Kolla att uttrycket inte pekar på sig själv? (dålig förklaring ik)

Användningsfall:

A, användaren skriver in (x =) i ruta A1.

1. Kommentaren "x =" sparas som en string i ruta A1

B, användaren skriver in (1) i ruta B1

1. Konstanten 1 sparas som ett expresion av typen floating point number. 

C, användaren skriver in (y =) i ruta A2.

1. Kommentaren "x =" sparas som en string i ruta A1

D, användaren skriver in (B1+1) i ruta B2

1. Ruta B2 visar summan av konstantent "1" och värdet som har lagrats på adressen B1. 

E, användaren skriver in (B1+1) i ruta B1

1. Ruta B1 försöker visa värdet på adressen B1 adderat med "1"
2. Eftersom den kallar på sig själv, genereras ett exception
3. Error visas i ruta B1

F, användaren skriver in (A1 + B1) i ruta C1

1. Ruta C1 försöker visa summan av värdena i ruta A1 och B1.
2. Eftersom en/båda av A1 och B1 är strings visar ruta C1 :Error

G, användaren skriver in (B1 + B2) i ruta B3

1. Ruta B3 läser en string från B1 och en konstant från B2
2. Iochmed att det är en string i B1 så ger B3 :Error

(Utan användarfall E)
1. Ruta B3 läser adresserna B1 & B2
2. Det hämtas konstanter från både B1 och B2
3. B3 visar: 1 + 2 -> 3
4. B3 visar siffran (3) i sitt fält.
