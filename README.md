# Úkol 1 - Email Sender

[![UTB FAI Task](https://img.shields.io/badge/UTB_FAI-Task-yellow)](https://www.fai.utb.cz/)
[![Java](https://img.shields.io/badge/Java-007396.svg?logo=java&logoColor=white)](https://www.java.com/)
[![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?logo=gradle&logoColor=white)](https://gradle.org/)

|                                  |                                |
| -------------------------------- | ------------------------------ |
| __Maximální počet bodů__         | 4 bodů                         |
| __Způsob komunikace s aplikací__ | Parametry předané při spuštění |
| __Způsob testování aplikace__    | Na základě odesílaných emailů  |

---

## 📝 Zadání úkolu 

Vaším prvním úkolem je doplnit implementaci třídy EmailSender, která umožní odesílat emailové zprávy pomocí SMTP protokolu. Třída EmailSender by měla umožnovat následující:

1. __Konstruktor EmailSender(String host, int port):__ Konstruktor otevře spojení se zadaným SMTP serverem na daném portu. 

2. __Metoda send(String from, String to, String subject, String text):__ Metoda odesílá emailovou zprávu z určeného emailu na zadaný email příjemce s daným předmětem a textem. 

3. __Metoda close():__ Metoda odesílá příkaz QUIT na SMTP server a zavírá spojení.

```java
package utb.fai;

import java.net.*;
import java.io.*;
 
public class EmailSender {
    /*
     * Constructor opens Socket to host/port. If the Socket throws an exception during opening,
     * the exception is not handled in the constructor.
     */
    public EmailSender(String host, int port) throws UnknownHostException, IOException {
       
    }
    /*
     * Sends email from an email address to an email address with some subject and text.
     * If the Socket throws an exception during sending, the exception is not handled by this method.
     */
    public void send(String from, String to, String subject, String text) throws IOException {
       
    }
   
    /*
     * Sends QUIT and closes the socket
     */
    public void close() {
       
    }
}
```

Druhým úkolem bude doplnění implementace ve třídě Main pro zpracování parametrů předaných aplikaci při spuštění. Při testování aplikace bude testovací nástroj tímto způsobem aplikaci předávat parametry a nasledně hodnotit chování vaší aplikace.

### Struktura pole argumentů parametrů
1. __args[0]__ - Adresa SMTP serveru _(String)_
1. __args[1]__ - Číslo portu SMTP serveru _(int)_
1. __args[2]__ - Email odesílatele _(String)_
1. __args[3]__ - Email příjemce _(String)_
1. __args[4]__ - Předmět emailu _(String)_
1. __args[5]__ - Obsah emailu _(String)_


```java
package utb.fai;

public class App {
 
    public static void main(String[] args) {
        // TODO: Implement input parameter processing

        try {
            EmailSender sender = new EmailSender("smtp.utb.cz", 25);
            sender.send("you@utb.cz", "you@utb.cz", "Email from Java", "Funguje to?\nSnad...");
            sender.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

>_**Poznámka:** Implementace a struktura kódu aplikace je libovolná a je zcela na vás, jak tento problém vyřešíte. Je však důležité, aby aplikace splňovala zadané požadavky._

---

## 🏆 Způsob hodnocení

Vaše implementace bude hodnocena na základě chování aplikace při testování různých scénářů. Automatizovaný testovací nástroj bude předávat vaší aplikaci různé parametry, včetně platných a neplatných, aby otestoval její chování za různých podmínek. V případě testování síťové komunikace mezi více klienty, testovací nástroj bude vytvářet virtuální klienty/servery za účelem ověření funkcionality.

Výsledné hodnocení bude záviset na celkovém počtu úspěšných testovacích případů. Počet bodů získaných z úlohy bude tedy záviset na celkové úspěšnosti při testování. Váš výsledný počet bodů bude určen následujícím vzorcem.

__VP__ = __MB__ * (__UT__ / __CPT__)

### Popis symbolů:

* __VP:__ Výsledný počet bodů.
* __MB:__ Maximální počet bodů pro danou úlohu.
* __UT:__ Počet úspěšných testovacích případů.
* __CPT:__ Celkový počet testovacích případů.

## ⚙️ Jak spustit automatizované hodnocení lokálně na svém počítači?

Automatizované hodnocení můžete spustit lokálně za účelem ověření funkčnosti vaší aplikace. K tomu slouží předpřipravený skript, který je dostupný v repozitáři tohoto úkolu. Výsledný report testování se bude nacházet v souboru ```test_report.html```.

###  Pro uživatele systému Linux:
Spusťte skript s názvem ```run_local_test.sh```.

### Pro uživatele systému Windows:
Spusťte skript s názvem ```run_local_test.bat```.

