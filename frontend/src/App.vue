<template>
  <div class="todo-app">
    <div class="glass-container">
      <h1 class="title">User's List</h1>
      <ul class="todo-list">
        <li v-for="(task, index) in tasks" :key="index" class="todo-item">
          <span>{{ task }}</span>
          <button class="delete-btn" @click="removeTask(index)">✕</button>
        </li>
      </ul>
      <input
        type="text"
        v-model="newTask"
        placeholder="Add a new task"
        class="todo-input"
      />
      <button @click="addTask" class="add-btn">Add</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      newTask: "",
      tasks: ["Learn Vue.js", "Build a To-Do App"],
    };
  },
  methods: {
    addTask() {
      if (this.newTask) {
        this.tasks.push(this.newTask);
        this.newTask = "";
      }
    },
    removeTask(index) {
      this.tasks.splice(index, 1);
    },
  },
};
</script>

<style scoped>
html, body {
  margin: 0;
  padding: 0;
  height: 100%;
  overflow: hidden; /* Disable both horizontal and vertical scrolling */
}

.todo-app {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  width: 100vw;
  background: url('assets/background.jpg') no-repeat center center;
  background-size: cover;
  background-attachment: fixed; /* Keeps the background fixed in place */
  position: fixed; /* Keeps the background from moving */
  top: 0;
  left: 0;
}

/* Container for frosted glass effect */
.glass-container {
  backdrop-filter: blur(12px);
  background: rgba(255, 255, 255, 0.2);
  padding: 20px;
  border-radius: 15px;
  box-shadow: 0 8px 32px rgba(0, 0, 0, 0.2);
  width: 550px;
  max-width: 90%;
  color: white;
  text-align: center;
  z-index: 1; /* Ensure the content is above the background */
}

/* Title styling */
.title {
  font-size: 2rem;
  margin-bottom: 20px;
}

/* List items */
.todo-list {
  list-style-type: none;
  padding: 0;
  margin-bottom: 20px;
}

.todo-item {
  display: flex;
  justify-content: space-between;
  background: rgba(255, 255, 255, 0.3);
  margin-bottom: 10px;
  padding: 10px;
  border-radius: 8px;
}

/* Delete button */
.delete-btn {
  background: none;
  border: none;
  color: white;
  font-size: 18px;
  cursor: pointer;
}

/* Task input */
.todo-input {
  width: 100%; /* Prendre toute la largeur disponible */
  padding: 10px;
  border-radius: 5px;
  border: none;
  margin-bottom: 15px;
  background: rgba(255, 255, 255, 0.3);
  color: white;
  box-sizing: border-box; /* S'assurer que le padding est inclus dans la largeur */
}



.todo-input:focus {
  outline: 0.5px solid white; /* Set the outline to white when focused */
}

/* Add button */
.add-btn {
  width: 25%; /* Make sure the button takes full width */
  padding: 10px;
  background-color: #4caf50;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.add-btn:hover {
  background-color: #45a049;
}

/* Media queries for responsiveness */
@media (max-width: 768px) {
  .glass-container {
    width: 90%;
  }
}


</style>
