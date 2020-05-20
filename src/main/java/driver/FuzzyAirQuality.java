package driver;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/*
"C:\Users\jakub\IdeaProjects\jfuzzy-driver\src\main\resources\fuzzy_air.fcl" 2 2 2
 */
public class FuzzyAirQuality {

    private static final String INDUSTRIAL_ACTIVITY = "industrial_activity";
    private static final String WIND_FORCE = "wind_force";
    private static final String TRAFFIC = "traffic";

    private static final String AIR_QUALITY = "air_quality";

    public static void main(String[] args) {
        if (args == null || args.length != 4) {
            System.out.println("Invalid number of arguments. Try again");
            return;
        }

        final String fileName = args[0];
        final int industrialActivity = Integer.parseInt(args[1]);
        final int windForce = Integer.parseInt(args[2]);
        final int traffic = Integer.parseInt(args[3]);

        FIS fis = FIS.load(fileName, false);

        FunctionBlock functionBlock = fis.getFunctionBlock(null);
        JFuzzyChart.get().chart(functionBlock);
        functionBlock.setVariable(INDUSTRIAL_ACTIVITY, industrialActivity);
        functionBlock.setVariable(WIND_FORCE, windForce);
        functionBlock.setVariable(TRAFFIC, traffic);
        functionBlock.evaluate();

        Variable tip = functionBlock.getVariable(AIR_QUALITY);
        JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);
        // System.out.println(fuzzyRuleSet);
    }

}