import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 */
public class MainClass
{

    private static final int MAX_NUMBER_OF_RETRIES = 3;
    private final static long TIME_TO_LIVE = 6000; // 1 min
    static int i = 20;
    static
    {
        System.out.println(" args" + i);
    }

    void method1(final List<?> args)
    {
        final Object obj = new Object();
        System.out.println(" args" + args.toString());
    }

    <T> void method2(final List<T> args)
    {
        System.out.println(" args" + args.toString());
    }

    /**
     * This method will parse the Fabric Interface DN to get the value in format
     * of the contents in ethInterfaceProfile list values
     *
     * Example: dn=topology/pod-1/node-102/sys/phys-[eth1/5]
     * return 102:eth1/5
     *
     * @param fabIntfDn
     * @return
     */
    //    public String parseFabIntfDn(final String fabIntfDn)
    //    {
    //        String fabInterface = null;
    //        final String[] slashArray = fabIntfDn.split("/");
    //        if (slashArray.length > 2)
    //        {
    //            final String nodeId = slashArray[2].split("-")[1].trim();
    //            final String ethStr = fabIntfDn.substring(fabIntfDn.lastIndexOf('[') + 1, fabIntfDn.lastIndexOf(']')).trim();
    //            fabInterface = nodeId + ":" + ethStr;
    //        }
    //        return fabInterface;
    //    }
    private static boolean isFeedOld(final Date lastUpdated)
    {
        final Date currentTime = new Date();
        final long timeDiff = currentTime.getTime() - lastUpdated.getTime();
        if (timeDiff > TIME_TO_LIVE)
        {
            return true;
        }
        return false;
    }

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(final String[] args) throws InterruptedException {

        final Date old = new Date();
        Thread.sleep(6000);
        if (isFeedOld(old))
        {
            final Date newDate = new Date();
            System.out.println("sunnnnnnnnnnnnnnnnnnn**** new " + newDate + " old" + old);
            final long diff = newDate.getTime() - old.getTime();
            System.out.println("sunnnnnnnnnnnnnnnnnnn****" + diff);
            System.out.println("sunnnnnnnnnnnnnnnnnnn****" + old.compareTo(newDate));
        }

        final Set<Integer> portNumberChangeSet = new HashSet<>();

        if (!portNumberChangeSet.contains(null))
        {
            System.out.println("sunnnnnnnnnnnnnnnnnnnnnnnnnnportNumberChangeSet *****" + portNumberChangeSet);
        }
	}