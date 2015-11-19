/**
 * Copyright (c) 2015, Ernesto Corbellini, Ekumen
 * 
 * Based on actionlib code by Stuart Glaser, Willow Garage
 * 
 * Pending license.
 * 
 */


package com.github.ekumen.rosjava_actionlib;


import java.util.Vector;


/**
 * State machine for the action client.
 * 
 * Comments:
 *   - The state returned on a transition is actually a vector of states that should be transitioned in sequence.
 * 
 */
// TODO: change class name to ClientStateMachine
class CommStateMachine {
  // Local class to hold the states
  static class ClientStates {
    final int INVALID_TRANSITION = -2;
    final int NO_TRANSITION = -1;
    final int WAITING_FOR_GOAL_ACK = 0;
    final int PENDING = 1;
    final int ACTIVE = 2;
    final int WAITING_FOR_RESULT = 3;
    final int WAITING_FOR_CANCEL_ACK = 4;
    final int RECALLING = 5;
    final int PREEMPTING = 6;
    final int DONE = 7;
    final int LOST = 8;
  }
  
  ActionGoal goal;
  int latestGoalStatus;
  int state;
  int nextState;
    
  
  /**
   * Constructor
   */
  //public void CommStateMachine(ActionGoal actionGoal, transition_callback?, feedback_callback?, send_goal_function, send_cancel_function)
  //public void CommStateMachine(ActionGoal actionGoal, transition_callback?, feedback_callback?, ActionGoalTrigger)
  public void CommStateMachine(ActionGoal actionGoal)
  {
    // interface object for the callbacks?
    // store arguments locally in the object
    // 
    
    goal = actionGoal;
    
  }
  
  /*
   * Compare two objects.
   */
  public bool equals(CommStateMachine obj)
  {
    return actionGoal.goalId.id == obj.actionGoal.goalId.id;
  }
  
  public void setState(int State)
  {
  }
  
  /**
   * Update the state of the client based on the current state and the goal state.
   * Note: This method uses a mutex in the original implementation so we make it synchronized.
   */
  public synchronized void updateStatus(int statusArray)
  {
    int status;
    
    if (this.state != ClienStates.DONE)
    {
      status = _find_status_by_goal_id(status_array, self.action_goal.goal_id.id);
      
      // we haven't heard of the goal?
      if (!status)
      {
        if (this.state != ClientStates.WAITING_FOR_GOAL_ACK && this.state != ClientStates.WAITING_FOR_RESULT && this.state != ClientStates.DONE)
        {
          markAsLost();
        }
        return;
      }
      
      this.latestGoalStatus = status;
      
      // Determine the next state
      
      //if (this.state
      
    }
    
  }
  
  public void transitionTo(int toState)
  {
  }
  
  /**
   * Get the next state transition depending on the current client state and the goal state.
   * Note: this replaces the transition lookup table from the original implementation.
   */
  private Vector getTransition(int goalStatus)
  {
    Vector stateList;
    
    switch (this.state)
    {
      case ClientStates.WAITING_FOR_GOAL_ACK:
        switch (goalStatus)
        {
          case ActionGoal.GoalStates.PENDING:
            stateList.add(ClientStates.PENDING);
            break;
          case ActionGoal.GoalStates.ACTIVE:
            stateList.add(ClientStates.ACTIVE);
          break;
          case ActionGoal.GoalStates.REJECTED:
          break;
          case ActionGoal.GoalStates.RECALLING:
          break;
          case ActionGoal.GoalStates.RECALLED:
          break;
          case ActionGoal.GoalStates.PREEMPTED:
          break;
          case ActionGoal.GoalStates.SUCCEEDED:
          break;
          case ActionGoal.GoalStates.ABORTED:
          break;
          case ActionGoal.GoalStates.PREEMPTING:
          break;
        }
        break;
      case ClientStates.PENDING:
        break;
      case ClientStates.ACTIVE:
        break;
      case ClientStates.WAITING_FOR_RESULT:
        break;
      case ClientStates.WAITING_FOR_CANCEL_ACK:
        break;
      case ClientStates.RECALLING:
        break;
      case ClientStates.PREEMPTING:
        break;
      case ClientStates.DONE:
        break;
    }
  }
  
  public void markAsLost()
  {
  }
  
  public void updateResult(int statusResult)
  {
  }  
  
}