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
    val student1 = student("Tarun",110)

    val student2 = student("Vignesh",105)

    val marker = attendanceMarker()

    var currentDate = LocalDate.now()

    val record1 = marker.markAttendance(student1,currentDate.toString(),true)
    val record2 = marker.markAttendance(student2,currentDate.toString(),false)

    println("Roll Number: ${student1.rollNumber} \nStudent Name: ${student1.name} \nAttendance: ${record1.getStatus()} \nDate: ${record1.date}")

    // println("\nRoll Number: ${student2.rollNumber} \nStudent Name: ${student2.name} \nAttendance: ${record2.getStatus()} \nDate: ${record2.date}")

    marker.show(record2)
    {
        println("\nRoll Number: ${it.student.rollNumber} \nStudent Name: ${it.student.name} \nAttendance: ${record2.getStatus()} \nDate: ${record2.date}")
    }
}