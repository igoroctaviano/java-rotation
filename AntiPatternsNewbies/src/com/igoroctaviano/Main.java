package com.igoroctaviano;

public class Main {

    public static void main(String[] args) {
        /* String concatenation */
        String s = "";
        for (Person p : persons) { s += ", " + p.getName(); }
        s = s.substring(2); // remove first comma

        /* This is a real memory waster. The repeated concatenation of strings in a loop causes
         * excess garbage and array copying. Moveover it is ugly that the resulting string has to be fixed
         * for an extra comma. Amazingly in 2016 there are still people that believe that the compiler optimizes
         * this somehow. It doesnt even in Java 8! Some morons have even benchmarked the execution time to prove
         * that its fine. No, it isnt fine to produce lots of unnecessary garbage.
         */

        StringBuilder sb = new StringBuilder(persons.size() * 16); // well estimated buffer
        for (Person p : persons) {
            if (sb.length() > 0) sb.append(", "); // the JIT optimizes the if away out of the loop (peeling)
            sb.append(p.getName);
        }

        /* Lost StringBuffer performance */
        StringBuffer sb = new StringBuffer();
        sb.append("Name: ");
        sb.append(name + '\n');
        sb.append("!");
        // ...
        String s = sb.toString();

        /* This looks like optimizes code, but it isnt optimal yet. So why do you optimize in the first place
         * if you then fail to do it properly? Go all the way! The most obvious mistake is the string concatenation
         * in the 3th line. In the line 4 appending a char would be faster than appending a String. An also
         * major omission is the missing length initialization of the buffer which may incur unnecessary resizing
         * (array copying). In JDK 1.5 and above a StringBuilder instead of StringBuffer shoudl have been used:
         * because it is only a local variable the implicit synchronization is overkill. Actually, using simple
         * String concatenation compiles to almost perfect byte code: its only missing the length initialization.
         * */

        StringBuilder sb = new StringBuilder(100);
        sb.append("Name: ");
        sb.append(name);
        sb.append("\n!");
        String s = sb.toString();

        String s = "Name: " + name + "\n!";

        /* Testing for string equality */
        if (name.compareTo("John") == 0) ...
        if (name == "John") ...
        if (name.equals("John")) ...
        if ("".equals(name)) ...

        /*
        * None of the above comparisons is wrong - but neither are they really good. The compareTo method is overkill
        * and too verbose. The == operator tests for object identity which is probably not what you want. The equals
        * method is the way to go, but reversing the constant and variable whould give you extra safety if name is null.
        * */

        if ("John".equals(name)) ...
        if (name.length() == 0) ...
        if (name.isEmpty()) ...

        /* Converting numbers to Strings */
        "" + get.size()
        new Integer(set.size()).toString()

        /*
        * The return type of the set.Size() method is int. A convertion to String is wanted. These two examples in fact
        * do the convertion. But the first incurs the penalty of a concatenation operation (translates to (new StringBuilder())
        * .append(i).toString()). And the second creates an intermediate Integer wrapper. The correct way of doing it is one
        * of these
        * */

        Integer.toString(set.size());

        /* Parsing and converting numbers */
        int v = Integer.valueOf(str).intValue();
        int w = Long.valueOf(Double.valueOf(str).longValue()).intValue();

        /* Learn how to use the API without allocation unnecessary objets. */

        int v = Integer.parseInt(str);
        int w = (int) Double.parseDouble(str);

        /* Not taking advantage of immutable objets */
        zero = new Integer(0);
        return Boolean.valueOf("true");

        /* Integer as well as Boolean are immutable. Thus it doesnt make sense to create several objects that
         * represent the same value. Those classes have built-in caches for frequently used intances. In the case
          * of Boolean there are even only two possible instances. The programmer can take advantege of this: */

        zero = Integer.valueOf(0);
        return Boolean.TRUE;
    }
}
