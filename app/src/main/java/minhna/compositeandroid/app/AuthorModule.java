package minhna.compositeandroid.app;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import minhna.compositeandroid.model.Author;

/**
 * Created by Administrator on 28-Feb-17.
 */

@Module
public class AuthorModule {
    @Provides
    @Singleton
    Author provideAuthor(){
        return new Author("Minh Nguyen");
    }
}
