Vagrant.configure(2) do |config|
  if Vagrant.has_plugin?("vagrant-cachier")
    config.cache.scope = :box
  end

  ## Vagrant vm configuration
  config.vm.box = "ubuntu/trusty64"
  config.vm.network "forwarded_port", guest:27017, host:27017
  config.vm.hostname = 'todos-app'

  ## Share folders between your host and vm
  # config.vm.synced_folder "./HOST_FOLDER", "/VM_FOLDER", create: true

  ## Inline script execution
  config.vm.provision "shell", run: "always", inline: <<-SHELL
    wget -qO- https://gist.github.com/MartinsThiago/8a6782ad27d7232c23c3/raw/mongodb_precise.sh | sh

    dummy=`wget -qO- http://beta.json-generator.com/api/json/get/LHF0nzJ`
    echo "for (var i in $dummy) {db.todo.save($dummy[i])}" > todoInsert.json
    mongo todo-app todoInsert.json
  SHELL

  # External script execution
  # config.vm.provision "shell", run: "always", path: "./<script.sh>"

end