package minhna.compositeandroid.app;

import javax.inject.Singleton;

import dagger.Component;
import minhna.compositeandroid.model.Author;
import minhna.compositeandroid.view.MainActivity;

/**
 * Created by Administrator on 28-Feb-17.
 */

@Singleton
@Component(modules = {AuthorModule.class})
public interface AuthorComponent {
    void inject(MainActivity activity);

    Author provideAuthor();
    String provideAwardsString();
}
