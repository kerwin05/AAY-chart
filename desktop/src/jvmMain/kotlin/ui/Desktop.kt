package ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.aay.common.RadarChartStudent
import com.aay.common.model.Student
import com.aay.common.model.StudentConstant
import com.aay.common.model.WorkBook
import utils.DataUtils
import widget.LazyColumnScrollbar
import widget.TextSingle

@Composable
fun Desktop() {

    val mStudent = DataUtils.mWorkBooks[DataUtils.mWorkIndex.value].students[DataUtils.mStudentIndex.value]

    Row(modifier = Modifier.fillMaxSize()) {

        Box(modifier = Modifier.weight(0.1f).fillMaxHeight()) {
            val stateVertical = rememberLazyListState(0)
            LazyColumnScrollbar(modifier = Modifier.fillMaxSize(), state = stateVertical) {
                itemsIndexed(DataUtils.mWorkBookState) { index: Int, item: WorkBook ->
                    TextSingle(item.name, modifier = Modifier.clickable {
                        DataUtils.mStudentIndex.value = 0
                        DataUtils.mWorkIndex.value = index
                    })
                }
            }
        }

        Box(modifier = Modifier.weight(0.1f).fillMaxHeight()) {
            val stateVertical = rememberLazyListState(0)
            LazyColumnScrollbar(modifier = Modifier.fillMaxSize(), state = stateVertical) {
                itemsIndexed(DataUtils.mWorkBookState[DataUtils.mWorkIndex.value].students) { index: Int, item: Student ->
                    TextSingle(item.name, modifier = Modifier.clickable {
                        DataUtils.mStudentIndex.value = index
                    })
                }
            }
        }

        Column(modifier = Modifier.weight(0.6f).fillMaxHeight().align(Alignment.CenterVertically)) {

            Column {
                TextSingle("${StudentConstant.studentId}${mStudent.studentId}")
                TextSingle("${StudentConstant.name}${mStudent.name}")
                TextSingle("${StudentConstant.chinese}${mStudent.chinese}")
                TextSingle("${StudentConstant.math}${mStudent.math}")
                TextSingle("${StudentConstant.english}${mStudent.english}")
                TextSingle("${StudentConstant.biology}${mStudent.biology}")
                TextSingle("${StudentConstant.history}${mStudent.history}")
                TextSingle("${StudentConstant.geography}${mStudent.geography}")
                TextSingle("${StudentConstant.ethics}${mStudent.ethics}")
                TextSingle("${StudentConstant.totalScore}${mStudent.totalScore}")
            }

            Box(modifier = Modifier.fillMaxSize()) {
                RadarChartStudent(mStudent)
            }

        }


    }

}