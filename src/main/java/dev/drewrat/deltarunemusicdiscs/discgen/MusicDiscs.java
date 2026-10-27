package dev.drewrat.deltarunemusicdiscs.discgen;

import dev.drewrat.deltarunemusicdiscs.DeltaruneMusicDiscs;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MusicDiscs {
    public static final DeferredRegister.Items DISC_ITEMS = DeferredRegister.createItems(DeltaruneMusicDiscs.MODID);
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, DeltaruneMusicDiscs.MODID);
    public static final DeferredRegister<JukeboxSong> JUKEBOX_SONGS = DeferredRegister.create(Registries.JUKEBOX_SONG, DeltaruneMusicDiscs.MODID);

    public static final MusicDisc[] musicDiscs = {
            new MusicDisc("disc_beginning", "Beginning - Toby Fox", "0:57", "1"),
            new MusicDisc("disc_school", "School - Toby Fox", "1:20", "1"),
            new MusicDisc("disc_the_legend", "The Legend - Toby Fox", "1:51", "1"),
            new MusicDisc("disc_lancer", "Lancer - Toby Fox", "0:48", "1"),
            new MusicDisc("disc_rude_buster", "Rude Buster - Toby Fox", "1:15", "1"),
            new MusicDisc("disc_empty_town", "Empty Town - Toby Fox", "1:23", "1"),
            new MusicDisc("disc_field_of_hopes_and_dreams", "Field of Hopes and Dreams - Toby Fox", "2:41", "1"),
            new MusicDisc("disc_fanfare", "Fanfare (from \"Rose of Winter\") - Toby Fox", "0:15", "1"),
            new MusicDisc("disc_lantern", "Lantern - Toby Fox", "1:08", "1"),
            new MusicDisc("disc_checker_dance", "Checker Dance - Toby Fox", "1:18", "1"),
            new MusicDisc("disc_quiet_autumn", "Quiet Autumn - Toby Fox", "1:18", "1"),
            new MusicDisc("disc_scarlet_forest", "Scarlet Forest - Toby Fox", "2:08", "1"),
            new MusicDisc("disc_thrash_machine", "Thrash Machine - Toby Fox", "0:54", "1"),
            new MusicDisc("disc_vs_lancer", "Vs. Lancer - Toby Fox", "0:42", "1"),
            new MusicDisc("disc_vs_susie", "Vs. Susie - Toby Fox", "1:21", "1"),
            new MusicDisc("disc_card_castle", "Card Castle - Toby Fox", "1:01", "1"),
            new MusicDisc("disc_rouxls_kaard", "Rouxls Kaard - Toby Fox", "0:19", "1"),
            new MusicDisc("disc_hip_shop", "Hip Shop - Toby Fox", "0:39", "1"),
            new MusicDisc("disc_chaos_king", "Chaos King - Toby Fox", "1:46", "1"),
            new MusicDisc("disc_the_circus", "The Circus - Toby Fox", "0:51", "1"),
            new MusicDisc("disc_the_world_revolving", "THE WORLD REVOLVING - Toby Fox", "1:41", "1"),
            new MusicDisc("disc_the_holy", "THE HOLY - Toby Fox", "0:48", "1"),
            new MusicDisc("disc_your_power", "Your Power - Toby Fox", "0:13", "1"),
            new MusicDisc("disc_a_town_called_hometown", "A Town Called Hometown - Toby Fox", "1:53", "1"),
            new MusicDisc("disc_you_can_always_come_home", "You Can Always Come Home - Toby Fox", "1:40", "1"),
            new MusicDisc("disc_dont_forget", "Don't Forget - Toby Fox, Laura Shigihara", "0:51", "1"),

            new MusicDisc("disc_faint_glow", "Faint Glow - Toby Fox", "1:17", "2"),
            new MusicDisc("disc_girl_next_door", "Girl Next Door - Toby Fox", "0:54", "2"),
            new MusicDisc("disc_my_castle_town", "My Castle Town - Toby Fox", "2:07", "2"),
            new MusicDisc("disc_queen", "Queen - Toby Fox", "0:56", "2"),
            new MusicDisc("disc_a_cybers_world", "A CYBER'S WORLD? - Toby Fox", "2:46", "2"),
            new MusicDisc("disc_berdly", "Berdly - Toby Fox", "0:46", "2"),
            new MusicDisc("disc_smart_race", "Smart Race - Toby Fox", "1:06", "2"),
            new MusicDisc("disc_welcome_to_the_city", "WELCOME TO THE CITY - Toby Fox", "1:54", "2"),
            new MusicDisc("disc_spamton", "Spamton - Toby Fox", "0:42", "2"),
            new MusicDisc("disc_nows_your_chance_to_be_a", "NOW'S YOUR CHANCE TO BE A - Toby Fox", "1:07", "2"),
            new MusicDisc("disc_pandora_palace", "Pandora Palace - Toby Fox", "1:39", "2"),
            new MusicDisc("disc_acid_tunnel_of_love", "Acid Tunnel of Love - Toby Fox", "1:30", "2"),
            new MusicDisc("disc_its_pronounced_rules", "It's Pronounced \"Rules\" - Toby Fox", "1:01", "2"),
            new MusicDisc("disc_lost_girl", "Lost Girl - Toby Fox", "1:20", "2"),
            new MusicDisc("disc_attack_of_the_killer_queen", "Attack of the Killer Queen - Toby Fox, Lena Raine, Marcy Nabors", "2:00", "2"),
            new MusicDisc("disc_knock_you_down", "Knock You Down !! - Toby Fox", "2:26", "2"),
            new MusicDisc("disc_the_dark_truth", "The Dark Truth - Toby Fox", "1:12", "2"),
            new MusicDisc("disc_big_shot", "BIG SHOT - Toby Fox", "2:22", "2"),
            new MusicDisc("disc_dialtone", "Dialtone - Toby Fox", "0:44", "2"),
            new MusicDisc("disc_sans", "sans. - Toby Fox", "0:22", "2"),
            new MusicDisc("disc_until_next_time", "Until Next Time - Toby Fox", "1:02", "2"),

            new MusicDisc("disc_flashback_excerpt", "Flashback (Excerpt) - Toby Fox", "0:32", "3"),
            new MusicDisc("disc_feature_presentation", "Feature Presentation - Toby Fox", "0:42", "3"),
            new MusicDisc("disc_and_now_for_todays_sponsors", "And Now For Today's Sponsors...! - Toby Fox", "0:31", "3"),
            new MusicDisc("disc_mike_the_board_please", "MIKE, the BOARD, please! - Toby Fox", "0:32", "3"),
            new MusicDisc("disc_sandy_board", "Sandy Board - Toby Fox", "1:18", "3"),
            new MusicDisc("disc_adventure_board", "Adventure Board - Toby Fox", "0:59", "3"),
            new MusicDisc("disc_quiz", "Quiz! - Toby Fox", "1:16", "3"),
            new MusicDisc("disc_ruder_buster", "Ruder Buster - Toby Fox", "1:46", "3"),
            new MusicDisc("disc_physical_challenge", "Physical Challenge - Toby Fox", "1:47", "3"),
            new MusicDisc("disc_welcome_to_the_green_room", "Welcome to the Green Room - Toby Fox", "1:30", "3"),
            new MusicDisc("disc_paradise_paradise", "Paradise, Paradise - Toby Fox", "2:30", "3"),
            new MusicDisc("disc_sound_check", "Sound Check - Toby Fox", "0:25", "3"),
            new MusicDisc("disc_raise_up_your_bat", "Raise Up Your Bat - Toby Fox", "2:13", "3"),
            new MusicDisc("disc_glowing_snow", "Glowing Snow - Toby Fox", "2:22", "3"),
            new MusicDisc("disc_tv_world", "TV WORLD - Toby Fox", "2:09", "3"),
            new MusicDisc("disc_its_tv_time", "It's TV Time! - Toby Fox", "2:45", "3"),
            new MusicDisc("disc_hall_of_fame", "Hall of Fame - Toby Fox", "0:30", "3"),
            new MusicDisc("disc_black_knife", "Black Knife - Toby Fox", "1:57", "3"),
            new MusicDisc("disc_sword", "SWORD - Toby Fox", "2:21", "3"),
            new MusicDisc("disc_glaceir", "GLACEIR - Toby Fox", "1:07", "3"),
            new MusicDisc("disc_burning_eyes", "BURNING EYES - Toby Fox", "1:05", "3"),

            new MusicDisc("disc_old_wooden_rafters", "Old wooden rafters - Toby Fox", "1:38", "4"),
            new MusicDisc("disc_another_day_in_hometown", "Another day in hometown - Toby Fox", "2:19", "4"),
            new MusicDisc("disc_castle_funk", "Castle Funk - Toby Fox", "2:56", "4"),
            new MusicDisc("disc_gingerbreak_house", "Gingerbread House - Toby Fox", "1:27", "4"),
            new MusicDisc("disc_the_distance_between_two", "The distance between two - Toby Fox", "0:42", "4"),
            new MusicDisc("disc_atrium", "ATRIUM - Toby Fox", "1:00", "4"),
            new MusicDisc("disc_dark_sanctuary", "Dark Sanctuary - Toby Fox", "1:46", "4"),
            new MusicDisc("disc_from_now_on", "From Now On (Battle 2) - Toby Fox", "1:48", "4"),
            new MusicDisc("disc_gyaa_ha_ha", "Gyaa Ha ha! - Toby Fox", "1:15", "4"),
            new MusicDisc("disc_fireplace", "Fireplace - Toby Fox", "2:37", "4"),
            new MusicDisc("disc_a_dark_zone", "A DARK ZONE - Toby Fox", "2:18", "4"),
            new MusicDisc("disc_wise_words", "Wise words - Toby Fox", "0:42", "4"),
            new MusicDisc("disc_piano_that_may_not_be_played_that_well", "Piano that may not be played that well - Toby Fox", "0:42", "4"),
            new MusicDisc("disc_hammer_of_justice", "Hammer of Justice - Toby Fox", "2:13", "4"),
            new MusicDisc("disc_12am", "12am - Toby Fox", "0:34", "4"),
            new MusicDisc("disc_the_second_sanctuary", "The Second Sanctuary - Toby Fox", "2:46", "4"),
            new MusicDisc("disc_ripple", "Ripple - Toby Fox", "2:31", "4"),
            new MusicDisc("disc_13am", "13am - Toby Fox", "1:26", "4"),
            new MusicDisc("disc_the_third_sanctuary", "The Third Sanctuary - Toby Fox", "4:07", "4"),
            new MusicDisc("disc_dark_place", "Dark Place - Toby Fox", "0:58", "4"),
            new MusicDisc("disc_crumbling_tower", "Crumbling Tower - Toby Fox", "2:49", "4"),
            new MusicDisc("disc_spawn", "SPAWN - Toby Fox", "1:11", "4"),
            new MusicDisc("disc_guardian", "GUARDIAN - Toby Fox", "3:46", "4"),
            new MusicDisc("disc_need_a_hand", "Need a hand!? - Toby Fox", "0:46", "4"),
            new MusicDisc("disc_the_place_where_it_rained", "The place where it rained - Toby Fox", "2:52", "4"),
            new MusicDisc("disc_the_ol_jitterbug", "The Ol' Jitterbug - Toby Fox", "0:22", "4"),
            new MusicDisc("disc_neverending_night", "Neverending Night - Toby Fox", "1:39", "4"),
            new MusicDisc("disc_with_hope_crossed_on_our_hearts", "With Hope Crossed On Our Hearts - Toby Fox", "1:39", "4"),
            new MusicDisc("disc_catswing", "Catswing - Toby Fox", "1:58", "4"),
            new MusicDisc("disc_air_waves", "Air Waves - Toby Fox", "2:00", "4"),

            new MusicDisc("disc_inappropriate_recycling", "Inappropriate Recycling - Toby Fox", "1:36", "5"),
            new MusicDisc("disc_pirate_dojo", "Pirate Dojo - Toby Fox", "0:52", "5"),
            new MusicDisc("disc_4rd_sanctuary", "4rd Sanctuary - Toby Fox", "1:19", "5"),
            new MusicDisc("disc_festival", "Festival - Toby Fox", "2:00", "5"),
            new MusicDisc("disc_i_guess_im_in_love", "I guess I'm in love - Toby Fox, Itoki Hana", "2:57", "5"),
            new MusicDisc("disc_your_dads_best_friend", "Your Dad's Best Friend - Toby Fox", "0:28", "5"),
            new MusicDisc("disc_garden_of_hopes_and_dreams", "Garden of Hopes and Dreams - Toby Fox, insaneintherainmusic", "3:23", "5"),
            new MusicDisc("disc_rakuichi_buster", "Rakuichi Buster - Toby Fox, Rakuichi", "1:49", "5"),
            new MusicDisc("disc_the_diner_song_of_best_friends", "The Diner Song of Best Friends - Toby Fox", "1:25", "5"),
            new MusicDisc("disc_quiet_glade", "Quiet Glade - Toby Fox", "3:17", "5"),
            new MusicDisc("disc_who_might_you_be", "Who might you be? - Toby Fox", "1:04", "5"),
            new MusicDisc("disc_petal_dance", "Petal Dance - Toby Fox", "1:32", "5"),
            new MusicDisc("disc_sunset_of_seven_suns", "Sunset of Seven Suns - Toby Fox", "1:36", "5"),
            new MusicDisc("disc_sunset_of_7_suns", "The Sunset of 7 Suns (early ver.) - Toby Fox", "1:10", "5"),
            new MusicDisc("disc_shop_3", "Shop 3 - Toby Fox", "1:15", "5"),
            new MusicDisc("disc_violet_tactics", "Violet Tactics - Toby Fox", "1:05", "5"),
            new MusicDisc("disc_flower_foyer", "Flower Foyer - Toby Fox", "0:55", "5"),
            new MusicDisc("disc_flower_castle", "Flower Castle - Toby Fox", "4:30", "5"),
            new MusicDisc("disc_thousand_cafe_zukan", "Thousand Cafe Zukan - Toby Fox", "1:29", "5"),
            new MusicDisc("disc_pink", "Pink - Toby Fox", "1:13", "5"),
            new MusicDisc("disc_cutie_mew_mew_magic", "Cutie Mew Mew Magic - Toby Fox, Camellia", "3:04", "5"),
            new MusicDisc("disc_running_sky", "Running Sky - Toby Fox", "2:22", "5"),
            new MusicDisc("disc_flower_man", "Flower Man - Toby Fox, Camellia", "3:12", "5"),
            new MusicDisc("disc_that_day", "That Day - Toby Fox", "1:30", "5"),
            new MusicDisc("disc_dreamwatchers", "Dreamwatchers - Toby Fox", "1:17", "5"),
            new MusicDisc("disc_weak_flowers", "Weak Flowers - Toby Fox", "1:42", "5"),
            new MusicDisc("disc_walking_home", "Walking Home - Toby Fox", "2:16", "5"),
            new MusicDisc("disc_field_of_hopes_and_dreams_from_deltarune_piano_collections_vol_1_credits_version", "Field of Hopes and Dreams (From \"DELTARUNE Piano Collections Vol. 1\") - Credits Version - Toby Fox, Trevor Alan Gomes", "1:39", "5"),
            new MusicDisc("disc_egg", "Scarlet Forest (From \"DELTARUNE Piano Collections Vol. 1\") - Excerpt (Ch. 5 Egg Room) - Toby Fox, Trevor Alan Gomes", "1:39", "5")
    };

    public static void register(IEventBus eventBus) {
        for (var disc : musicDiscs) {
            disc.register(DISC_ITEMS, SOUND_EVENTS, JUKEBOX_SONGS);
        }

        DISC_ITEMS.register(eventBus);
        SOUND_EVENTS.register(eventBus);
        JUKEBOX_SONGS.register(eventBus);
    }
}
