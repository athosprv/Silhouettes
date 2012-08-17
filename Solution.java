   import java.io.*;
   import java.util.LinkedList;
   import java.util.Stack;

    public class Solution
   {
      private static LinkedList<listObj> sil1 = new LinkedList<listObj>();
      private static  LinkedList<listObj> sil2 = new LinkedList<listObj>();
      private static  LinkedList<listObj> finalSil = new LinkedList<listObj>();

      private static  Stack<Integer> st1 = new Stack<Integer>();
      private static  Stack<Integer> st2 = new Stack<Integer>();
      private static  Stack<Integer> finalSt = new Stack<Integer>();

       public static void run(BufferedReader in, PrintWriter out)

        throws IOException
      {
         action(in, out);
      }

       public static void action(BufferedReader in, PrintWriter out)throws IOException
      {
         String n = in.readLine();

         while(n!=null)
         {
            st1.add(0);
            st2.add(0);
            finalSt.add(0);

            insertLists(n, in);
            mergeLists();
            printList(out);

            out.println();
            out.flush();


            sil1.clear();
            sil2.clear();
            finalSil.clear();
            st1.clear();
            st2.clear();
            finalSt.clear();

            n = in.readLine();
         }
         out.flush();
      }

       public static void printList(PrintWriter out)
      {
         for(int i=0;i<finalSil.size();i++)
         {
            out.println(finalSil.get(i).x);
            out.println(finalSil.get(i).y);
         }
      }

       public static void mergeLists()
      {
         while(true)
         {

            try
            {
               if(sil1.size()==0 || sil2.size()==0)
               {
                  System.out.println(sil1.size() + " " + sil2.size());
                  if(sil1.size()==0)
                  {
                     for(int i =0;i<sil2.size(); i++)
                        finalSil.add(sil2.get(i));
                  }
                  else if(sil2.size()==0)
                  {
                     for(int i =0;i<sil1.size(); i++)
                        finalSil.add(sil1.get(i));
                  }
                  break;
               }

               listObj a = sil1.getFirst();
               listObj b = sil2.getFirst();

               if(a.x.compareTo(b.x)<0)
               {
                  st1.add(a.y);

                  if(st1.peek()<st2.peek())
                     a.y = st2.peek();

                  if(a.y!=finalSt.peek())
                  {
                     finalSt.add(a.y);
                     finalSil.add(a);
                     sil1.removeFirst();
                  }
                  else
                     sil1.removeFirst();
               }
               else if(a.x.compareTo(b.x)>0)
               {
                  st2.add(b.y);

                  if(st2.peek()<st1.peek())
                     b.y = st1.peek();

                  if(b.y!=finalSt.peek())
                  {
                     finalSt.add(b.y);
                     finalSil.add(b);
                     sil2.removeFirst();
                  }
                  else
                     sil2.removeFirst();
               }
               else if(a.x.compareTo(b.x)==0)
               {
                  listObj c;

                  if(a.y>=b.y)
                     c=a;
                  else
                     c=b;

                  st1.add(a.y);
                  st2.add(b.y);

                  if(c.y!=finalSt.peek())
                  {
                     finalSt.add(c.y);
                     finalSil.add(c);
                     sil1.removeFirst();
                     sil2.removeFirst();
                  }
                  else
                  {
                     sil1.removeFirst();
                     sil2.removeFirst();
                  }
               }
            }
                catch (Exception e){
                  break;}
         }

      }
       public static void insertLists(String n, BufferedReader in)throws IOException
      {

         int counter1= 0;
         int num1 = 0;
         int num2 = 0;

         try{
            while(n!=null)
            {
               if(n.equals(""))
               {
                  if(counter1==1)
                     break;
                  counter1=1;
                  n = in.readLine();
               }

               num1 = Integer.parseInt(n);
               n = in.readLine();
               num2 = Integer.parseInt(n);
               listObj app = new listObj(num1, num2);


               if(counter1==0)
                  sil1.add(app);
               if(counter1==1)
                  sil2.add(app);

               n = in.readLine();
            }
         }
             catch(Exception e){}

      }
       public static class listObj
      {
         Integer x;
         Integer y;


          public listObj()
         {
            x = 0;
            y = 0;
         }

          public listObj(int a, int b)
         {
            x = a;
            y = b;
         }
          public  void print()
         {
            System.out.println(x + " " + y);
         }

      }
   }




