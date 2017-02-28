package minhna.compositeandroid.app;

import java.util.Random;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import minhna.compositeandroid.model.Author;
import minhna.compositeandroid.model.Award;

/**
 * Created by Administrator on 28-Feb-17.
 */

@Module
public class AuthorModule {
    @Provides
    @Singleton
    Author provideAuthor(){
        return new Author("Minh Nguyen", new Award(new Random().nextInt(6)+5));//random 5 to 10 (without +5 is 0 to 5)
    }

    @Provides
    @Singleton
    String provideAwardsString(){
        return String.valueOf(provideAuthor().award.awardsCount);
    }
}
