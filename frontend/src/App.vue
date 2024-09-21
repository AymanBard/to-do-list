<template>
  <div class="container mt-5">
    <h1>To-Do List</h1>
    <form>
      <div class="mb-3">
        <label for="task" class="form-label">Add a new task</label>
        <input type="text" class="form-control" id="task" placeholder="Enter a task">
      </div>
      <button type="submit" class="btn btn-primary">Add Task</button>
    </form>
  </div>
</template>

<script>
export default {
  name: 'App',
}
</script>
