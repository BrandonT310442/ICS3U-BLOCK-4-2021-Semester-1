package week4;

public class BayviewGlenPools {
   
    public static void main(String[] args) {
        final int length = 20;
         final int width = 8;
         final int shallowLength = 5;
         final int transition = 7;
         final int shallowHeight = 3;
         final int deepHeight = 8;
         final int linerCost = 2;


         double volume = getVolume(length, width, shallowLength, shallowHeight, transition, deepHeight);
    
         System.out.println(volume);
         double surfaceArea = getSurfaceArea(length, width, shallowLength, shallowHeight, transition, deepHeight);

         System.out.println(surfaceArea);
        }

        private static double getVolume(int length, int width, int shallowLength, int shallowHeight, int transition,
        int deepHeight) {

            double transitionLength = Math.sqrt((transition*transition) - (deepHeight - shallowHeight)*(deepHeight-shallowHeight));
double volumeDeep = deepHeight*(length-shallowLength-transitionLength)*width;
double volumeTranstion = (transitionLength*(deepHeight-shallowHeight))/2*width;
double aboveVolumeTransition = transitionLength*shallowHeight*width;

double volumeShallow = shallowLength*shallowHeight*width;

return volumeDeep+volumeTranstion+volumeShallow+aboveVolumeTransition;
            
}

    private static double getSurfaceArea(int length, int width, int shallowLength, int shallowHeight, int transition,
            int deepHeight) {

               

                double transitionLength = Math.sqrt((transition*transition) - ((deepHeight - shallowHeight)*(deepHeight-shallowHeight)));               
                double deepLength = length-shallowLength-transitionLength;
                double areaBack = width*deepHeight;

                double areaFront = width*shallowHeight;

                double shallowBottom = width*shallowLength;

                double deepBottom = width*deepLength;

                double deepSide = deepLength*deepHeight*2;

                double shallowSides = shallowLength*shallowHeight*2;

                double aboveTransitionSides = transitionLength*shallowHeight*2;

                double transitionSides = transitionLength*(deepHeight-shallowHeight);

                double transitionBotoom = transition*width;

                return areaFront+areaBack+shallowBottom+deepBottom+deepSide+shallowSides+aboveTransitionSides+transitionSides+transitionBotoom;


                  
      
    }

   
}
