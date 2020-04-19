package org.pinkanki.server;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.validation.Validated;
import io.reactivex.Single;
import javax.validation.constraints.NotBlank;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import org.bson.Document;

/**
 * @author Frank Wray
 * @since 0.1
 */
@Controller("/")
@Validated
public class DBController {
    final MongoClient mongoClient = MongoClients.create(
        "");
    final MongoDatabase database = mongoClient.getDatabase("pinkanki");
    final MongoCollection<Document> identity = database.getCollection("identity");

    @Get(uri = "/", produces = MediaType.APPLICATION_JSON)
    public Single<String> app() {
        long documentCount = identity.estimatedDocumentCount();
        return Single.just("Welcome to the PinKanki-Server!" + " Found " + documentCount + " documents.");
    }
        
    @Get(uri = "/member/{number}", produces = MediaType.APPLICATION_JSON)
    public Single<String> getMember(@NotBlank String number) {
        String record = identity.find(Filters.eq("memberNumber", number)).first().toJson();
        return Single.just(record);
    }
}
