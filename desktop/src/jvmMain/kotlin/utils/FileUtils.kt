package utils

import com.aay.common.model.Student
import com.aay.common.model.StudentConstant
import com.aay.common.model.WorkBook
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.math.BigDecimal
import java.math.RoundingMode

object FileUtils {

    fun readXlsx() {
        val filePath = "/Users/kerwin/Desktop/me/AAY-chart/assets/12班学生成绩.xlsx"

        val file = File(filePath)
        val fileInputStream = file.inputStream()
        val workbook = XSSFWorkbook(fileInputStream)

        DataUtils.mWorkBooks.clear()
        val sheetIterator = workbook.sheetIterator()
        while (sheetIterator.hasNext()) {
            val sheet = sheetIterator.next()

            val mWorkBook = WorkBook(sheet.sheetName)
            if (sheet.physicalNumberOfRows > 0) {
                val kind = sheet.getRow(sheet.firstRowNum)
                sheet.forEachIndexed { index, row ->
                    if (index > 0 && kind.physicalNumberOfCells > 0) {
                        val student = Student(
                            row.getCell(kind.getColumnIndexByValue(StudentConstant.studentId)).stringCellValue,
                            row.getCell(kind.getColumnIndexByValue(StudentConstant.name)).stringCellValue,
                            row.getCell(kind.getColumnIndexByValue(StudentConstant.chinese)).numericCellValue.roundToTwoDecimalPlaces(),
                            row.getCell(kind.getColumnIndexByValue(StudentConstant.math)).numericCellValue.roundToTwoDecimalPlaces(),
                            row.getCell(kind.getColumnIndexByValue(StudentConstant.english)).numericCellValue.roundToTwoDecimalPlaces(),
                            row.getCell(kind.getColumnIndexByValue(StudentConstant.biology)).numericCellValue.roundToTwoDecimalPlaces(),
                            row.getCell(kind.getColumnIndexByValue(StudentConstant.history)).numericCellValue.roundToTwoDecimalPlaces(),
                            row.getCell(kind.getColumnIndexByValue(StudentConstant.geography)).numericCellValue.roundToTwoDecimalPlaces(),
                            row.getCell(kind.getColumnIndexByValue(StudentConstant.ethics)).numericCellValue.roundToTwoDecimalPlaces(),
                            row.getCell(kind.getColumnIndexByValue(StudentConstant.totalScore)).numericCellValue.roundToTwoDecimalPlaces()
                        )
                        mWorkBook.students.add(student)
                    }
                }
            }
            DataUtils.mWorkBooks.add(mWorkBook)

            val json = JsonUtil.toJson(DataUtils.mWorkBooks)
            val file = File("/Users/kerwin/Desktop/me/AAY-chart/assets/12班学生成绩.json")
            file.bufferedWriter().use { out ->
                out.write(json)
            }

        }

        workbook.close()
        fileInputStream.close()
    }

    private fun Row.getColumnIndexByValue(value: String): Int {
        for (cell in this) {
            val cellValue = cell.stringCellValue
            if (cellValue == value) {
                return cell.columnIndex
            }
        }
        return 0
    }

    fun readJson(): String {
        val file = File("/Users/kerwin/Desktop/me/AAY-chart/assets/12班学生成绩.json")
        file.bufferedReader().use { reader ->
            return reader.readText()
        }
    }

    fun Double.roundToTwoDecimalPlaces(): Double {
        val decimal = BigDecimal(this)
            .setScale(2, RoundingMode.HALF_UP)
        return decimal.toDouble()
    }

}