package utils

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.google.gson.reflect.TypeToken
import com.aay.common.model.WorkBook

object DataUtils {

    var mWorkBooks: MutableList<WorkBook> = ArrayList()

    val mWorkBookState: SnapshotStateList<WorkBook> = mutableStateListOf()
    val mWorkIndex: MutableState<Int> = mutableStateOf(0)
    val mStudentIndex: MutableState<Int> = mutableStateOf(0)

    init {
        val json = FileUtils.readJson()
        val data: List<WorkBook> = JsonUtil.fromJson(json, object : TypeToken<List<WorkBook>>() {}.type)
        mWorkBooks = ArrayList(data)
        mWorkBookState.addAll(data)
    }

}