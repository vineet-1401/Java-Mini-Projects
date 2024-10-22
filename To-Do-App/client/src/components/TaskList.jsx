import React from "react";
import Task from "./Task";

const TaskList = ({ tasks, onEditTask, onDeleteTask, onToggleCompleted }) => {
  const reversedTasks = tasks.slice().reverse();
  return (
    <ul className=" ">
      {reversedTasks.map((task) => {
        console.log(task)
        return (
          <Task
            key={task.taskId}
            task={task}
            onEditTask={onEditTask}
            onDeleteTask={onDeleteTask}
            onToggleCompleted={onToggleCompleted}
          />
        )
      })}
    </ul>
  );
};

export default TaskList;
