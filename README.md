# Kytomator

## Setup

1. Install node.js >=4.2 & npm
2. Run npm install
3. Install redis-server
4. Make a local copy of app/config/server-config.js.dist without .dist and configure it
    * If you want to run the monitor server you need to configure your ssl certificates
5. Other prerequisites: Google Chrome (or Chromium linked to google-chrome) and chromedriver, must both be accessible from the path

## Run
The application contains four separate processes:
* Monitoring server: Allows you to view log files, task details etc. from the browser
* Queue server: The public endpoint where tasks can be sent to
* Fetch worker: A process which fetches the details of a remote task and creates an automation task
* Automation worker: A process which processes automation tasks, i.e. the real browser automation

All node scripts are located in the `app` directory.

### Monitoring server
Run `node app.monitor.js`.
* Logs, files, tasks monitor is available at `https://localhost:<Config.SSL_PORT>/static`, by default it would be `https://localhost:8443/static`
* Kue monitor is available at `http://localhost:<Config.kuePort>`, default is `http://localhost:3333`

### Queue server
Run `node app.queue.js`

Provides the following routes at `http://localhost:<Config.PORT>` (default is port `8080`):
* `POST /run-task`: Expects a body with a task, creates a new `fetch-task` job
* `GET /test-task?file=<optional-task-file>`: Adds a `automation` job to queue from a local task file in the `test-tasks` folder. The specific file can be set with the `file` parameter, otherwise a default file will be used as defined in the config.
* `GET /clean-up-jobs/:number?`: Removes `number` of finished tasks from the queue (queue maintenance)
* `GET /clean-up-failed-jobs/:number?`: Removes `number` of finished tasks from the queue (queue maintenance)

### Fetch worker
This worker fetches task details from a remote server: `node worker.fetch.js`.

### Automation worker
This worker runs the actual automation script: `node worker.automation.js`.
If you want to set up a remote worker, make sure to adjust the `queue` settings in the config so it can connect to the queue redis database


## Change notes
* All files are restructured and reside under the `app` directory
* In order to use the normal node.js modules strategy all JavaScript modules are located inside the `node_modules` folder inside the `app` directory. This might seem strange, because usually external modules are saved there but this is apparently the node.js way.
* ...
