package it.aulab.learningplatform.service;

import java.util.List;
import java.util.Map;

public interface CrudService<Read, ID, Create, Update> {
    List<Read> readAll();
    List<Read> read(Map<String, String> params);
    Read readOne(ID id) throws Exception;
    Read create(Create createDTO);
    Read update(ID id, Update updateDTO) throws Exception;
    Read delete(ID id) throws Exception;
}

/* Questo è un'interfaccia generica per definire un servizio CRUD (Create, Read, Update, Delete). Gli argomenti di tipo generico sono i seguenti:

Read: il tipo di oggetto restituito quando si esegue una lettura dal database;
ID: il tipo dell'identificatore dell'oggetto (ad esempio, Long);
Create: il tipo di oggetto utilizzato per creare un nuovo oggetto nel database;
Update: il tipo di oggetto utilizzato per aggiornare un oggetto esistente nel database.
L'interfaccia definisce cinque metodi:

readAll(): restituisce una lista di tutti gli oggetti presenti nel database;
read(Map<String, String> params): restituisce una lista di oggetti che soddisfano i criteri specificati dai parametri passati come mappa;
readOne(ID id): restituisce un oggetto dal database in base all'ID specificato;
create(Create createDTO): crea un nuovo oggetto nel database a partire dai dati forniti nell'oggetto Create;
update(Update updateDTO): aggiorna un oggetto esistente nel database a partire dai dati forniti nell'oggetto Update;
delete(ID id): elimina un oggetto dal database in base all'ID specificato. */