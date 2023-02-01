package alphaplus.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.*;
import mindustry.ctype.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.experimental.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import static mindustry.type.ItemStack.*;

public class AlphaplusBlocks{
	//list of blocks and environment
	public static Block oven, waterTurbine;
	
	public static void load() {
		oven = new GeneticCreafter("oven"){{
			requirements(Category.crafting, with(Items.lead, 45, Items.graphite, 30,Items.silicon,20));

            craftEffect = Fx.fireSmoke;
            outputItem = new ItemStack(Items.graphite, 1);
            craftTime = 90f;
            size = 2;
            hasItems = true;
            drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));

            consumes.item(Items.coal, 2);
		}};
		waterTurbine = new PowerGenerator("water turbine"){{
			requirements(Category.power, with(Items.lead, 45, Items.graphite, 30,Items.silicon,20));
			liquidCapacity = 5f;
			powerProduction = 5f;
			outputLiquid = LiquidStack(Liquid.water, 5f);
			hasLiquids = true;
			size 2;
			
			consumesLiquid(Liquids,water,0.2f);
		}};
	}
}