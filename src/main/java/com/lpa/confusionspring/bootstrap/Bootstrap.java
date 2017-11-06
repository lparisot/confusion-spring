package com.lpa.confusionspring.bootstrap;

import com.lpa.confusionspring.repositories.reactive.CommentReactiveRepository;
import com.lpa.confusionspring.repositories.reactive.DishReactiveRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {
    private DishReactiveRepository dishReactiveRepository;
    private CommentReactiveRepository commentReactiveRepository;

    public Bootstrap(DishReactiveRepository dishReactiveRepository, CommentReactiveRepository commentReactiveRepository) {
        this.dishReactiveRepository = dishReactiveRepository;
        this.commentReactiveRepository = commentReactiveRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Bootstrap run");
        /*

        dishReactiveRepository.deleteAll().block();
        commentReactiveRepository.deleteAll().block();

        Dish dishUthappizza = new Dish();
        dishUthappizza.setId("0");
        dishUthappizza.setName("Uthappizza");
        dishUthappizza.setImage("images/uthappiza.png");
        dishUthappizza.setCategory("mains");
        dishUthappizza.setLabel("Hot");
        dishUthappizza.setPrice("4.99");
        dishUthappizza.setFeatured(true);
        dishUthappizza.setDescription("A unique combination of Idian Uthappan (pancake) and Italian pizza, topped with Cerignola olives, ripe vine cherry tomatoes, Vidalia onion, Guntur chillies and Buffalo Paneer.");

        Comment commentLemon = new Comment();
        commentLemon.setRating(5);
        commentLemon.setComment("Imagine all the eatables, living in conFusion");
        commentLemon.setAuthor("John Lemon");
        commentLemon.setDate("2012-10-16T17:57:28.556094Z");
        commentReactiveRepository.save(commentLemon).block();
        dishUthappizza.addComment(commentLemon);

        Comment commentPaul = new Comment();
        commentPaul.setRating(4);
        commentPaul.setComment("Sends anyone to heaven, I wish I could get my mother-in-law to eat it!");
        commentPaul.setAuthor("Paul McVites");
        commentPaul.setDate("2014-09-05T17:57:28.556094Z");
        commentReactiveRepository.save(commentPaul).block();
        dishUthappizza.addComment(commentPaul);

        dishReactiveRepository.save(dishUthappizza).block();

        Dish dishZucchipakoda = new Dish();
        dishZucchipakoda.setId("1");
        dishZucchipakoda.setName("Zucchipakoda");
        dishZucchipakoda.setImage("images/zucchipakoda.png");
        dishZucchipakoda.setCategory("appetizer");
        dishZucchipakoda.setLabel("");
        dishZucchipakoda.setPrice("1.99");
        dishZucchipakoda.setFeatured(false);
        dishZucchipakoda.setDescription("Deep fried Zucchini coated with mildly spiced Chickpea flour batter accompanied with a sweet-tangy tamarind sauce.");

        Comment commentMichael = new Comment();
        commentMichael.setRating(3);
        commentMichael.setComment("Eat it, just eat it!");
        commentMichael.setAuthor("Mickael Jaikishan");
        commentMichael.setDate("2015-02-13T17:57:28.556094Z");
        commentReactiveRepository.save(commentMichael).block();
        dishZucchipakoda.addComment(commentMichael);

        Comment commentRingo = new Comment();
        commentRingo.setRating(4);
        commentRingo.setComment("Ultimate, Reaching for the stars!");
        commentRingo.setAuthor("Ringo Starry");
        commentRingo.setDate("2013-12-02T17:57:28.556094Z");
        commentReactiveRepository.save(commentRingo).block();
        dishZucchipakoda.addComment(commentRingo);

        dishReactiveRepository.save(dishZucchipakoda).block();
        */

    }
}
