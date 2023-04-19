package com.example.viewmodeldemo.ui.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewmodeldemo.model.MatchModel
import com.example.viewmodeldemo.model.TeamsRepository
import com.example.viewmodeldemo.util.Constants.TEAM_A

class CounterViewModel: ViewModel() {

    private val _teamInfo = MutableLiveData<MatchModel>()
    val teamInfo: LiveData<MatchModel> = _teamInfo

    private val _scoreA = MutableLiveData<Int>()
    val scoreA: LiveData<Int> = _scoreA

    private val _scoreB = MutableLiveData<Int>()
    val scoreB: LiveData<Int> = _scoreB

    fun getTeamInfo(teamId: Int){
        val teamInfo = TeamsRepository.matches[teamId]
        _teamInfo.value = teamInfo
        _scoreA.value = teamInfo.firstTeamScore
        _scoreB.value = teamInfo.secondTeamScore
    }

    fun setThreePoint(teamName: String) {
        if (teamName == TEAM_A) {
            _scoreA.value = _scoreA.value?.plus(3)
        }
        else {
            _scoreB.value = _scoreB.value?.plus(3)
        }
    }

    fun setTwoPoint(teamName: String) {
        if (teamName == TEAM_A) {
            _scoreA.value = _scoreA.value?.plus(2)
        }
        else {
            _scoreB.value = _scoreB.value?.plus(2)
        }
    }

    fun setFreeThrowPoint(teamName: String) {
        if (teamName == TEAM_A) {
            _scoreA.value = _scoreA.value?.plus(1)
        }
        else {
            _scoreB.value = _scoreB.value?.plus(1)
        }
    }

    fun reset() {
        _scoreA.value = 0
        _scoreB.value = 0
    }
}