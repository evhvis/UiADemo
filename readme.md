#UiA Demo

## Moduler
Prosjektet består av to submoduler
- Frontend - Angular prosjekt som leverer frontend og kopieres inn i backend prosjektet ved bygging
- RestServer - Spring boot prosjekt, basert på tomcat, som kjører restserver og server opp frontend ved kjøring av jar

## Oppsett
Frontend kjøres med 'ng serve' fra modulen sin mappe. Den starter automatisk på port 4200. Innlogging er navn og passord er navn, se evt. db seed i backend for mer info

Backend startes fra main metode i 'Application'. Den er restbasert med RestResource som restendepunkt. Det er lagt inn whitelisting av origin for frontend og det er enkel rollesjekk (token) for mange av kallene.

- Resttjenesten: http://localhost:8080/rest
- Frontend(ng serve): http://localhost:4200
- Frontend(statisk bygget inn i backend): http://localhost:8080

NB! den versjonen som hostes på port 8080 vil kun bli oppdatert når man kjører maven bygg på Frontend

## Bygging
Kjør 'mvn clean install' for å bygge frontend, backend og få de ut som en jar-pakke som er kjørbar. Kopier ut fra target i RestServer. 

Application klassen ligger i 'no.knowit.Application'

# Oppgaver

## Oppgave 1:
Legg til DTO (Data Transfer Object) for Employee i en klasse for å sende over nettverk.

Klassen skal inneholde følgende felter og getter+setter:
- id: Long;
- firstName: string;
- lastName: string;
- String company: string;
- hireType: EmployeeHireType;
- birthday: LocalDate;
- workingRole: WorkingRole;

Klassen 'EmployeesOverallInfo' skal ha en liste med Employee klassen med navnet 'employees'.

Opprett en getmetode på relativt endepunkt '/employees' i RestResource som mapper fra database entiteten for employees til 
DTO og returnerer 'EmployeesOverallInfo' med status OK (200). Hent fra employeeRepository

## 

## Oppgave 3
Legg til sjekk på innlogget token mot "hardcoded" token fra DB og sjekk på rolle. 
- Token er en header
- Bruker hentes fra database med userRepository.getByPasskey(...)
- Strip bort 'Bearer ' før man kaller på DB
- Sjekk rollen på brukeren

Returner:
- Token og admin -> send employees og 200
- Token og user -> send 401
- Mangler token -> send 403

## Oppgave 4
Opprettet en postMetode på relativt endepunkt '/employees' som tar imot DTO fra oppgave 1 i body og lagrer brukeren i databasen. 
Det skal gjøres en tilsvarende sjekk på at brukeren er admin som i oppgave #3. 

- Hvis admin og entity OK -> lagre
- Hvis ikke admin eller feil -> returner 403
- (optianl) send 400 hvis admin og entity ikke OK

## Oppgave 5
Bruk auth0 modulen for å legge JWT for å estatte "authkode" fra db og endre til å velidere denne. Ha felt for brukerid og rolle.

