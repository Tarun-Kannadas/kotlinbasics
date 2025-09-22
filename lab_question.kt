import java.time.LocalDate

open class person(open var name:String)

data class student(override var name:String, var rollNumber:Int):person(name)

data class attendanceRecord(val student:student, val date:String, val status:Boolean)
{
    fun getStatus():String
    {
        return if (status == true) "Present" else "Absent"
    }
}

class attendanceMarker
{
    fun markAttendance (student:student, date:String, status:Boolean):attendanceRecord
    {
        return attendanceRecord(student,date,status)
    }

    fun markAttendance (record:attendanceRecord):attendanceRecord
    {
        return record
    }

    fun show(record:attendanceRecord,action:(attendanceRecord)->Unit)
    {
        action(record)
    }
}

fun main()
{
    val student1 = student("Tarun",2002)

    val marker = attendanceMarker()

    var currentDate = LocalDate.now()

    val record = marker.markAttendance(student1,currentDate.toString(),true)

    println("Roll Number: ${student1.rollNumber} \nStudent Name: ${student1.name} \nAttendance: ${status.getStatus()} \nDate: ${record.date}")
}