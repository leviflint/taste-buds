package com.tastebuds.webapp.Storage;

import com.tastebuds.webapp.resources.Post;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class PostPopulator implements CommandLineRunner {
  private PostStorage postStorage;
  private PostRepository postRepo;

    public PostPopulator(PostStorage postStorage, PostRepository postRepo) {
        this.postStorage = postStorage;
        this.postRepo = postRepo;
    }


    @Override
    public void run(String...args)throws Exception{
        Post cajunShrimp = new Post("shrimp","Cajun Shrimp", "https://www.wellplated.com/cajun-shrimp-pasta/", "#Creamy","img/cajun-pasta.jpg", "10/18/2020");
        postStorage.save(cajunShrimp);
        Post chili = new Post("steak","Chili", "https://pinchofyum.com/sunday-chili","#Spicy","img/chili.jpg", "10/20/2020");
        postStorage.save(chili);
        Post crownRoast = new Post("lamb", "Crown Roast", "https://www.bonappetit.com/recipe/crown-roast-of-lamb-with-rosemary-and-oregano", "#FancyTime", "https://assets.bonappetit.com/photos/57b0ca8f1b33404414976465/16:9/w_2560%2Cc_limit/mare_crown_roast_of_lamb_with_rosemary_and_oregano_h.jpg", "10/23/2020");
        postStorage.save(crownRoast);
        Post salmonTikka = new Post("salmon", "Salmon Tikka", "https://c.ndtvimg.com/2018-11/a4e5k52o_tikka_625x300_22_November_18.jpg", "#LivinLaVidaSousVide", "https://c.ndtvimg.com/2018-11/a4e5k52o_tikka_625x300_22_November_18.jpg", "10/30/2020");
        postStorage.save(salmonTikka);
        Post asianTofu = new Post("tofu", "Asian Garlic Tofu", "https://spicysouthernkitchen.com/asian-garlic-tofu/", "#FeelingHealthy", "https://spicysouthernkitchen.com/wp-content/uploads/tofu-13.jpg", "11/4/2020");
        postStorage.save(asianTofu);
        Post chickenLegs = new Post("chicken", "Vinegar-Braised Chicken Legs", "https://www.bonappetit.com/recipe/vinegar-braised-chicken-legs", "#CrispySkin", "https://assets.bonappetit.com/photos/58fcc1230b8aa427e91c6e7f/16:9/w_2560%2Cc_limit/20170404-HEALTHYISH7232.jpg", "11/10/2020");
        postStorage.save(chickenLegs);
        Post stuffedTenderloin = new Post("pork", "Stuffed Pork Tenderloin", "https://natashaskitchen.com/stuffed-pork-tenderloin/", "#Oink", "https://natashaskitchen.com/wp-content/uploads/2018/12/Stuffed-Pork-Tenderloin-2-768x1152.jpg", "11/12/2020");
        postStorage.save(stuffedTenderloin);
        Post tofuScramble = new Post("tofu", "Tofu Scramble", "https://lovingitvegan.com/vegan-tofu-scramble/", "#Vegan", "https://lovingitvegan.com/wp-content/uploads/2018/03/Vegan-Tofu-Scramble-17.jpg", "11/17/2020");
        postStorage.save(tofuScramble);
        Post seitanTacos = new Post("seitan", "Seitan Tacos", "https://weelicious.com/vegans-and-carnivores-unite-seitan-tacos/", "#TacoTuesday", "https://weelicious.com/imager/weelicious_com/wp-content/uploads/2012/07/Seitan-Tacos1_4bc69d0481021c299b9329d2b470c61d.jpg", "11/26/2020");
        postStorage.save(seitanTacos);
        Post chickenTagine = new Post("chicken", "Chicken Tagine", "https://www.foodandwine.com/recipes/saffron-chicken-tagine", "#Saffron", "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F9%2F2015%2F01%2Fsaffron-chicken-tagine-XL-RECIP0717.jpg", "12/2/2020");
        postStorage.save(chickenTagine);
        Post lambLeg = new Post("lamb", "Leg of Lamb", "https://www.feastingathome.com/herb-crusted-leg-of-lamb-with-mint-gremolata/", "#MintyCool", "https://www.feastingathome.com/wp-content/uploads/2014/04/lamb-leg-1021.jpg", "12/3/2020");
        postStorage.save(lambLeg);
        Post shakshuka = new Post("eggs", "Shakshuka", "https://www.thedeliciouscrescent.com/moroccan-style-poached-eggs/", "#SpiceGirl", "https://www.thedeliciouscrescent.com/wp-content/uploads/2016/01/Moroccan-Eggs-in-Tomato-Sauce-2.jpg", "12/5/2020");
        postStorage.save(shakshuka);
        Post cedarSalmon = new Post("salmon", "Cedar-Plank Salmon", "http://bbqblvd.com/bbq-salmon-recipes-cedar-plank-fish/", "#JustKeepSwimming", "https://barbecueblvd.com/wp-content/uploads/cedar_plank_salmon_bbq_blvd.jpg", "12/7/2020");
        postStorage.save(cedarSalmon);


    }
}

