package Sem6Lab5;


/**
* Sem6Lab5/TaskableHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Sem6Lab5.idl
* 12 ������ 2019 �. 14:19:27 MSK
*/

abstract public class TaskableHelper
{
  private static String  _id = "IDL:Sem6Lab5/Taskable:1.0";

  public static void insert (org.omg.CORBA.Any a, Sem6Lab5.Taskable that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Sem6Lab5.Taskable extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (Sem6Lab5.TaskableHelper.id (), "Taskable");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Sem6Lab5.Taskable read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_TaskableStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Sem6Lab5.Taskable value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static Sem6Lab5.Taskable narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Sem6Lab5.Taskable)
      return (Sem6Lab5.Taskable)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Sem6Lab5._TaskableStub stub = new Sem6Lab5._TaskableStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static Sem6Lab5.Taskable unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Sem6Lab5.Taskable)
      return (Sem6Lab5.Taskable)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Sem6Lab5._TaskableStub stub = new Sem6Lab5._TaskableStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}